/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import java.util.Arrays;

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {

	/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private String[] playerNamesForDisplay;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

	private int[] dices;

	private int[][] scores;
	private boolean[][] filledCategories;

	public static void main(String[] args) {
		new Yahtzee().start(args);
	}

	public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers + 1];
		playerNamesForDisplay = new String[nPlayers];

		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i] = dialog.readLine("Enter name for player " + i);
			playerNamesForDisplay[i - 1] = playerNames[i];
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNamesForDisplay);

		dices = new int[N_DICE];
		scores = new int[nPlayers + 1][N_SUM_CATEGORIES];
		filledCategories = new boolean[nPlayers + 1][N_CATEGORIES];

		playGame();
	}

	private void playGame() {
		for (int i = 1; i <= N_SCORING_CATEGORIES; i++) {
			for (int j = 1; j <= nPlayers; j++) {
				playerTurn(j, i);
			}
		}
		showGameResults();

	}

	// Function updates all scoring categories and prints the winner
	private void showGameResults() {
		int winnerPlayerID = 1;
		int winnerPlayerScore = 0;

		for (int i = 1; i <= nPlayers; i++) {
			// show results on display
			showPlayerGameResults(i);

			int currentPlayerScore = playerTotalScore(i);

			if (currentPlayerScore > winnerPlayerScore) {
				winnerPlayerScore = currentPlayerScore;
				winnerPlayerID = i;
			}
		}

		display.printMessage("Winner is " + playerNames[winnerPlayerID] + " with " + winnerPlayerScore + " score");
	}

	// Function shows player results on display
	private void showPlayerGameResults(int playerID) {
		display.updateScorecard(UPPER_SCORE, playerID, scores[playerID][UPPER_SCORE_SUM]);
		display.updateScorecard(UPPER_BONUS, playerID, scores[playerID][BONUS_SCORE_SUM]);
		display.updateScorecard(LOWER_SCORE, playerID, scores[playerID][LOWER_SCORE_SUM]);
		display.updateScorecard(TOTAL, playerID, playerTotalScore(playerID));
	}

	// Function returns player's total score
	private int playerTotalScore(int playerID) {
		int sum = 0;

		for (int i = 0; i < N_SUM_CATEGORIES; i++) {
			sum += scores[playerID][i];
		}

		return sum;
	}

	// Function is used to play one round of game
	// Where round contains, rolling && change/replace dices, and choosing
	// categories
	private void playerTurn(int playerID, int roundID) {
		display.printMessage(roundID + "'th Round, " + playerNames[playerID] + "'s Turn, Time to roll the dice");

		rollDice(playerID);
		changeDices();
		chooseCategory(playerID);

	}

	// Function allows user to roll the dice and updated display accordingly
	private void rollDice(int playerID) {
		// Wait for click
		display.waitForPlayerToClickRoll(playerID);

		display.printMessage("Rolling Dices");

		// Randomize dices
		randomizeAllDices();

		// Display dices
		display.displayDice(dices);

		display.printMessage("Dices are rolled");
	}

	private void randomizeAllDices() {
		boolean[] changeList = new boolean[N_DICE];

		for (int i = 0; i < N_DICE; i++) {
			changeList[i] = true;
		}

		randomizeDices(changeList);
	}

	// Function assigns new values to dices according to changeList
	private void randomizeDices(boolean[] changeList) {
		for (int i = 0; i < N_DICE; i++) {
			if (changeList[i]) {
				dices[i] = rgen.nextInt(DICE_MIN, DICE_MAX);
			}
		}
	}

	// Function allows user to change dices, N_TRIES times max,
	// Function returns if user presses on Roll Again button without choosing
	// any dices
	private void changeDices() {
		display.printMessage("Time to change dices");

		for (int i = 0; i < N_TRIES; i++) {
			// Wait player to select dices to change
			display.waitForPlayerToSelectDice();

			// Getting information about dices
			boolean[] selectStatuses = selectStatuses();

			// If dices are not selected to change breaking for loop
			if (noSelections(selectStatuses)) {
				display.printMessage("No dices selected to roll again, choose category");
				return;
			}

			// Randomizing selected dices
			randomizeDices(selectStatuses);
			display.displayDice(dices);
		}

		display.printMessage("No more tries to change dices, choose category");
	}

	// Function returns list of booleans where each value determines if dice is
	// selected or not
	private boolean[] selectStatuses() {
		boolean[] selectStatuses = new boolean[N_DICE];

		for (int i = 0; i < N_DICE; i++) {
			selectStatuses[i] = display.isDieSelected(i);
		}

		return selectStatuses;
	}

	// Function returns true if non of the dices are selected for change
	private boolean noSelections(boolean[] selectStatuses) {
		for (int i = 0; i < N_DICE; i++) {
			if (selectStatuses[i]) {
				return false;
			}
		}

		return true;
	}

	// Function allow user to choose category and updates scores accordingly
	private void chooseCategory(int playerID) {
		int category = selectedCategory(playerID);
		int score = calculateScore(category);

		display.updateScorecard(category, playerID, score);
		display.printMessage(playerNames[playerID] + " Got " + score + " in this round");

		updateSumScoringCategories(playerID, category, score);
	}

	// Function waits and returns selected category from user which is not
	// filled yet
	private int selectedCategory(int playerID) {
		while (true) {
			int result = display.waitForPlayerToSelectCategory();

			if (!categoryFilled(playerID, result)) {
				return result;
			}
		}
	}

	// Function returns false if this category is not filled yet for received
	// user
	// and marks category as filled
	private boolean categoryFilled(int playerID, int category) {
		if (!filledCategories[playerID][category]) {
			filledCategories[playerID][category] = true;
			return false;
		}

		return true;
	}

	// Function updates sum scoring categories for player
	private void updateSumScoringCategories(int playerID, int category, int score) {
		// Update lower score if cateogry < sixe
		if (category >= ONES && category <= SIXES) {
			scores[playerID][UPPER_SCORE_SUM] += score;

			// check if user can get upper bonus
			if (scores[playerID][UPPER_SCORE_SUM] >= 63) {
				scores[playerID][BONUS_SCORE_SUM] = 35;
			}

			return;
		}

		scores[playerID][LOWER_SCORE_SUM] += score;
	}

	private int calculateScore(int category) {
		switch (category) {
		case ONES:
			return countNumberNScore(category);
		case TWOS:
			return countNumberNScore(category);

		case THREES:
			return countNumberNScore(category);
		case FOURS:
			return countNumberNScore(category);
		case FIVES:
			return countNumberNScore(category);
		case SIXES:
			return countNumberNScore(category);
		case THREE_OF_A_KIND:
			return countThreeOfAKindScore();
		case FOUR_OF_A_KIND:
			return countFourOfAKindScore();
		case FULL_HOUSE:
			return countFullHouseScore();
		case SMALL_STRAIGHT:
			return countSmallStraightScore();
		case LARGE_STRAIGHT:
			return countLargeStraightScore();
		case YAHTZEE:
			return countYathzeeScore();
		case CHANCE:
			return countChanceScore();
		default:
			return 0;
		}

	}

	// Function counts score for "Number" categories
	// "Number"s are categories from ones to sixes :D
	private int countNumberNScore(int num) {
		int score = 0;

		for (int i = 0; i < N_DICE; i++) {
			if (dices[i] == num) {
				score += num;
			}
		}

		return score;
	}

	// Function checks if dices are matching three of a kind rules
	// And returns score according to match
	private int countThreeOfAKindScore() {
		return countNOfAKindScore(3);
	}

	// Function checks if dices are matching four of a kind rules
	// And returns score according to match
	private int countFourOfAKindScore() {
		return countNOfAKindScore(4);
	}

	private int countNOfAKindScore(int n) {
		if (nKindOfDices(n, false)) {
			return sumDices();
		}

		return 0;
	}

	// Function checks if dices are matching full house rules
	// And returns score according to match
	private int countFullHouseScore() {
		if (nKindOfDices(3, true) && nKindOfDices(2, true)) {
			return 25;
		}

		return 0;
	}

	// Function returns true if minimum N same dices are stored in "dices" array
	// (when equal = false)
	// Function returns true if N same dices are stored in "dices" array (when
	// equal = true)
	private boolean nKindOfDices(int n, boolean equal) {
		for (int i = DICE_MIN; i <= DICE_MAX; i++) {
			int count = 0;

			for (int j = 0; j < N_DICE; j++) {
				if (dices[j] == i) {
					count++;
				}
			}

			if (equal && count == n) {
				return true;
			}

			if (!equal && count >= n) {
				return true;
			}
		}

		return false;
	}

	// Function sums and returns dice values
	private int sumDices() {
		int sum = 0;

		for (int i = 0; i < N_DICE; i++) {
			sum += dices[i];
		}

		return sum;
	}

	// Function checks if dices are matching small straight rules
	// And returns score according to match
	private int countSmallStraightScore() {
		return countLStraightScore(4, 30);
	}

	// Function checks if dices are matching large straight rules
	// And returns score according to match
	private int countLargeStraightScore() {
		return countLStraightScore(5, 40);
	}

	private int countLStraightScore(int l, int score) {
		if (containsStaightL(l)) {
			return score;
		}

		return 0;
	}

	// Function returns true if dices are containing straight with minimum l
	// length
	private boolean containsStaightL(int l) {
		int[] copyOfDices = new int[N_DICE];
		for (int i = 0; i < N_DICE; i++) {
			copyOfDices[i] = dices[i];
		}

		Arrays.sort(copyOfDices);

		int maxSize = 0;
		int counter = 1;

		for (int i = 1; i < N_DICE; i++) {
			if (copyOfDices[i] - copyOfDices[i - 1] == 1) {
				counter++;
			} else {
				if (counter > maxSize) {
					maxSize = counter;
				}

				counter = 1;
			}
		}

		if (counter > maxSize) {
			maxSize = counter;
		}

		return maxSize >= l;
	}

	// Function checks if dices are matching yathzee rules
	// And returns score according to match
	private int countYathzeeScore() {
		if (nKindOfDices(5, true)) {
			return 50;
		}

		return 0;
	}

	// Function returns score for change type
	private int countChanceScore() {
		return sumDices();
	}
}



































/*
// * File: Yahtzee.java
// * ------------------
// * This program will eventually play the Yahtzee game.
// */
//
//import java.util.Arrays;
//
//import acm.io.*;
//import acm.program.*;
//import acm.util.*;
//
//public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
//
//	public static void main(String[] args) {
//		new Yahtzee().start(args);
//	}
//	
//	public void run() {
//		IODialog dialog = getDialog();
//		nPlayers = dialog.readInt("Enter number of players");
//		while (nPlayers < 1 || nPlayers > MAX_PLAYERS) {
//			nPlayers = dialog.readInt("Invalid number of players. Enter number between 1 and 4");
//		}
//		playerNames = new String[nPlayers];
//		for (int i = 1; i <= nPlayers; i++) {
//			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
//		}
//		display = new YahtzeeDisplay(getGCanvas(), playerNames);
//		playGame();
//		getWinner();
//	}
//	/*
//	 * prints who won the game after it is finished.
//	 */
//	private void getWinner() {
//		int maxIndex = 0;
//		for (int i = 0; i < nPlayers; i++) {
//			if (scores[i][3] > scores[maxIndex][3]) {
//				maxIndex = i;
//			}
//		}
//		String message = playerNames[maxIndex] + ", You Won. Congratulations!";
//		display.printMessage(message);
//	}
//	/*
//	 * filling scores and wasPlayed arrays with 0 and false initially.
//	 */
//	private void fillScoresAndWasPlayed() {
//		for (int i = 0; i < nPlayers; i++) {
//			Arrays.fill(scores[i], 0);
//			Arrays.fill(wasPlayed[i], false);
//		}
//	}
//	/*
//	 * plays the game by iterating through all the moves, rolling/rerolling dice and updating scores.
//	 */
//	private void playGame() {
//		scores = new int[nPlayers][4];
//		wasPlayed = new boolean[nPlayers][N_CATEGORIES];
//		fillScoresAndWasPlayed();
//		for (int i = 1; i <= N_SCORING_CATEGORIES; i++) {
//			for (int j = 1; j <= nPlayers; j++) {
//				rollDice(j);
//				rerollDice(j);
//				updateUpperScore(j);
//				updateUpperBonus(j);
//				updateLowerScore(j);
//				updateTotalScore(j);
//			}
//		}
//	}
//	/*
//	 * updates total score.
//	 */
//    private void updateTotalScore(int n) {
//    	scores[n - 1][3] = scores[n - 1][0] + scores[n - 1][1] + scores[n - 1][2];
//    	display.updateScorecard(TOTAL, n, scores[n - 1][3]);
//	}
//    /*
//     * updates lower score.
//     */
//	private void updateLowerScore(int n) {
//		display.updateScorecard(LOWER_SCORE, n, scores[n - 1][2]);
//	}
//	/*
//	 * updates upper bonus score.
//	 */
//	private void updateUpperBonus(int n) {
//		if (scores[n - 1][0] >= 63) {
//			scores[n - 1][1] = 35;
//		}
//		display.updateScorecard(UPPER_BONUS, n, scores[n - 1][1]);
//	}
//	/*
//	 * updates upper score.
//	 */
//	private void updateUpperScore(int n) {
//		display.updateScorecard(UPPER_SCORE, n, scores[n - 1][0]);
//	}
//	/*
//	 * rerolls dice 2 times and updates the score with clicked category.
//	 * if the category is played already, the program will ask you to select another.
//	 */
//	private void rerollDice(int n) {
//		display.printMessage(playerNames[n - 1] + ", select dice to reroll");
//		
//		for (int i = 0; i < REROLL; i++) {
//			display.waitForPlayerToSelectDice();
//			for (int j = 0; j < N_DICE; j++) {
//				if (display.isDieSelected(j)) {
//					dice[j] = rgen.nextInt(1,6);
//				}
//			}
//			display.displayDice(dice);
//		}
//		
//		int categoryNumber = display.waitForPlayerToSelectCategory();
//		while (wasPlayed[n - 1][categoryNumber]) {
//			display.printMessage("This move is already played. Please select another category.");
//			categoryNumber = display.waitForPlayerToSelectCategory();
//		}
//		wasPlayed[n - 1][categoryNumber] = true;
//		boolean categoryCheck = checkCategory(dice, categoryNumber);
//		
//		if (!categoryCheck) {
//			display.updateScorecard(categoryNumber, n, 0);
//		}
//		else {
//			int score = getScore(categoryNumber, n, dice);
//			display.updateScorecard(categoryNumber, n, score);
//		}
//	}
//	/*
//	 * checks the satisfiability of the clicked category with the current dice.
//	 */
//	private boolean checkCategory(int[] dice, int categoryNumber) {
//		
//		if (categoryNumber <= SIXES || categoryNumber == CHANCE) {
//			return true;
//		}
//		
//		int[] diceStats = new int[6];
//		Arrays.fill(diceStats, 0);
//		
//		for (int i = 0; i < dice.length; i++) {
//			diceStats[dice[i] - 1]++;
//		}
//		
//		if (categoryNumber == SMALL_STRAIGHT) {
//			return ((diceStats[2] >= 1 && diceStats[3] >=1) && ((diceStats[0] >= 1  && diceStats[1] >= 1) || (diceStats[1] >= 1 && diceStats[4] >= 1) || (diceStats[4] >= 1 && diceStats[5] >= 1)));
//		}
//		
//		if (categoryNumber == LARGE_STRAIGHT) {
//			return ((diceStats[1] >= 1 && diceStats[2] >= 1 && diceStats[3] >= 1 && diceStats[4] >= 1) && (diceStats[0] >= 1 || diceStats[5] >= 1));
//		}
//		
//		Arrays.sort(diceStats);
//		
//		if (categoryNumber == THREE_OF_A_KIND) {
//			return diceStats[5] >= 3;
//		}
//		
//		if (categoryNumber == FOUR_OF_A_KIND) {
//			return diceStats[5] >= 4;
//		}
//
//		if (categoryNumber == FULL_HOUSE) {
//			return (diceStats[5] == 3 && diceStats[4] == 2);
//		}
//		
//		if (categoryNumber == YAHTZEE) {
//			return diceStats[5] == 5;
//		}
//		return false;
//	}
//	/*
//	 * returns the score amount for each category.
//	 */
//	private int getScore(int categoryNumber, int n, int[] dice) {
//		if (categoryNumber >= ONES && categoryNumber <= SIXES) {
//			int count = 0;
//			for (int i = 0; i < N_DICE; i++) {
//				if (dice[i] == categoryNumber) {
//					count++;
//				}
//			}
//			scores[n - 1][0] += count * categoryNumber;
//			return count * categoryNumber;
//		}
//		if (categoryNumber >= THREE_OF_A_KIND && categoryNumber <= CHANCE) {
//			scores[n - 1][2] += getLowScore(categoryNumber, dice);
//			return getLowScore(categoryNumber, dice);
//		}
//		return 0;
//	}
//	/*
//	 * returns the value of a score in the low section.
//	 */
//	private int getLowScore(int categoryNumber, int[] dice) {
//		if (categoryNumber == THREE_OF_A_KIND || categoryNumber == FOUR_OF_A_KIND || categoryNumber == CHANCE) {
//			int sum = 0;
//			for (int i = 0; i < dice.length; i++) {
//				sum += dice[i];
//			}
//			return sum;
//		}
//		if (categoryNumber == FULL_HOUSE) {
//			return 25;
//		}
//		if (categoryNumber == SMALL_STRAIGHT) {
//			return 30;
//		}
//		if (categoryNumber == LARGE_STRAIGHT) {
//			return 40;
//		}
//		if (categoryNumber == YAHTZEE) {
//			return 50;
//		}
//		return 0;
//	}
//	/*
//	 * rolls the dice by generating 5 random integers from 1 to 6.
//	 */
//	private void rollDice(int n) {
//    	display.printMessage(playerNames[n - 1] + ", your turn. click to roll the dice");
//    	for (int i = 0; i < N_DICE; i++) {
//    		dice[i] = rgen.nextInt(1,6);
//    	}
//    	display.waitForPlayerToClickRoll(n);
//		display.displayDice(dice);
//	}
//
///* Private instance variables */
//    private int[] dice = new int[N_DICE];
//	private int nPlayers;
//	private boolean[][] wasPlayed;
//	private int[][] scores;
//	private String[] playerNames;
//	private YahtzeeDisplay display;
//	private RandomGenerator rgen = new RandomGenerator();
//}