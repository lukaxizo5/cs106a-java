import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem36 extends ConsoleProgram {
	private static final int SENTINEL = 1000;
	
	public void run() {
		RandomGenerator rgen = new RandomGenerator();
		//true - heads, false - tails.
		int headsThreeTimes = 0;
		int otherCase = 0;
		for (int i = 0; i < SENTINEL; i++) {
			boolean coin1 = rgen.nextBoolean();
			boolean coin2 = rgen.nextBoolean();
			boolean coin3 = rgen.nextBoolean();
			if (coin1 && coin2 && coin3) {
				headsThreeTimes++;
			}
			else {
				otherCase++;
			}
		}
		println("The average number of flips to get heads 3 times in a row is: " + (double)(headsThreeTimes + otherCase) / headsThreeTimes);
	}
}