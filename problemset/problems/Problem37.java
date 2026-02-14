import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem37 extends ConsoleProgram {
	
	public void run() {
		RandomGenerator rgen = new RandomGenerator();
		while (true) {
			println("Enter a number between 0 and 36");
			print("? ");
			int n = readInt();
			if (n < 0 || n > 36) {
				println("You've finished playing roulette successfully!");
				break;
			}
			int rouletteNumber = rgen.nextInt(0, 36);
			if (rouletteNumber == n) {
				println("Roulette number is " + rouletteNumber);
				println("You Won, congratulations!");
			}
			else {
				println("Roulette number is " + rouletteNumber);
				println("You lost, better luck next time!");
			}
		}
	}
}