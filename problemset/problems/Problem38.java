import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem38 extends ConsoleProgram {

	public void run() {
		RandomGenerator rgen = new RandomGenerator();
		int currentAmount = 1000;
		while (currentAmount > 0) {
			println("Enter a bet amount and a number between 0 and 36");
			int bet = readInt();
			int userNumber = readInt();
			currentAmount -= bet;
			int rouletteNumber = rgen.nextInt(0, 36);
			if (rouletteNumber == userNumber) {
				currentAmount += bet * 2;
				println("Roulette number is " + rouletteNumber);
				println("You Won, congratulations!");
				println("Current Amount: " + currentAmount);
				
			} else {
				println("Roulette number is " + rouletteNumber);
				println("You lost, better luck next time!");
				println("Current Amount: " + currentAmount);
			}
		}
	}
}