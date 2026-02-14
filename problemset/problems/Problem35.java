import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem35 extends ConsoleProgram{
	private static final int SENTINEL = 1000;
	public void run() {
		RandomGenerator rgen = new RandomGenerator();
		//true - heads, false - tails.
		int heads = 0;
		int tails = 0;
		for (int i = 0; i < SENTINEL; i++) {
			boolean coin = rgen.nextBoolean();
			if (coin) {
				heads++;
			}
			else {
				tails++;
			}
		}
		println("The average number of flips to get heads is: " + (double)(heads + tails) / heads);
	}
}
