import acm.program.ConsoleProgram;

public class Problem24 extends ConsoleProgram {
	public void run() {
		int n = readInt("Insert natural number: ");
		int numberOfDivisors = 0;
		for (int i = 1; i <= n; i++){
			if (n % i == 0) {
				numberOfDivisors++;
			}
		}
		println(numberOfDivisors);
	}

}
