/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.program.*;
import acm.util.*;


public class Hangman extends ConsoleProgram {
	
	private int guessesLeft = 8;
	private String guess = "";
	private HangmanCanvas canvas;
	
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}

    public void run() {
    	while (true) {
    		play();
    		println("Wanna play again?");
    		String answer = readLine();
    		if (answer.toUpperCase().equals("YES")) {
    			canvas.removeAll();
    			canvas.setIncorrectGuesses();
    			guessesLeft = 8;
    			guess = "";
    			continue;
    		}
    		else {
    			break;
    		}
    	}
    	println("Thanks for playing!");
	}
    /*
     * plays the game in console.
     */
    private void play() {
    	canvas.reset();
		welcome();
		String secretWord = chooseSecretWord();
		boolean wonBefore = false;
		char c = ' ';
		while (guessesLeft > 0) {
			if (gameWon()) {
				println("You guessed the word: " + secretWord);
				println("You win.");
				wonBefore = true;
				break;
			}
			println("You have " + guessesLeft + " guesses left.");
			print("Your guess: ");
			while (true) {
				String input = readLine();
				if (input.length() != 1) {
					print("Wrong input, try again: ");
				}
				else {
					c = input.charAt(0);
					if ((int)c < 64 || ((int)c > 90 && (int)c < 97) || (int)c > 122 || input.length() != 1) {
						print("Wrong input, try again: ");
					}
					else {
						break;
					}
				}
			}
			checkChar(Character.toUpperCase(c), secretWord);
		}
		if (gameWon() && !wonBefore) {
				println("You guessed the word: " + secretWord);
				println("You win.");
			}
		else if (!gameWon()){
			gameLost(secretWord);
		}
	}
	/*
     * displays the game losing message.
     */
	private void gameLost(String secretWord) {
		println("You're completely hung.");
		println("The word was: " + secretWord);
		println("You lose.");
	}
	/*
	 * checks if guessed character is in the following string and updates its value. 
	 */
	private void checkChar(char c, String s) {
		String updatedGuess = "";
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				updatedGuess+=c;
				count++;
			}
			else updatedGuess+=guess.charAt(i);
		}
		if (count == 0) {
			println("There are no " + c + "'s in the word.");
			guessesLeft--;
			canvas.updateMan(guessesLeft);
			canvas.noteIncorrectGuess(c);
		}
		else {
			println("That guess is correct.");
		}
		guess = updatedGuess;
		if (!gameWon()) {
			println("The word now looks like this: " + updatedGuess);
		}
		canvas.displayWord(updatedGuess);
	}
	/*
	 * displays the game winning message.
	 */
	private boolean gameWon() {
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == '-') return false;
		}
		return true;
	}
	/*
	 * welcomes user to the game.
	 */
	private void welcome() {
		println("Welcome to Hangman!");
	}
	/*
	 * chooses and returns the secret word.
	 */
	private String chooseSecretWord() {
		HangmanLexicon lexicon = new HangmanLexicon();
		RandomGenerator rgen = new RandomGenerator();
		int index = rgen.nextInt(0, lexicon.getWordCount() - 1);
		String s = lexicon.getWord(index);
		for (int i = 0; i < s.length(); i++) {
			guess += '-';
		}
		canvas.displayWord(guess);
		print("The word now looks like this: " + guess);
		println();
		return s;
	}
}