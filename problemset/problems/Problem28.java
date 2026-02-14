import acm.program.ConsoleProgram;

public class Problem28 extends ConsoleProgram {
	public void run() {
		int number = 1;
		int counter = 0;
		while (number != -1) {
			number = readInt("Insert natural number: ");
			if (number % 2 == 0) {
				counter++;
			}
		}
		println(counter);
	}
}