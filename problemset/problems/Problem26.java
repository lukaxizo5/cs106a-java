import acm.program.ConsoleProgram;

public class Problem26 extends ConsoleProgram {
	public void run() {
		int firstNumber = readInt("Insert natural number: ");
		int secondNumber = readInt("Insert natural number: ");
		int GCD = 1;
		for (int i=2; i < Math.min(firstNumber, secondNumber); i++) {
			while (firstNumber % i == 0 && secondNumber % i == 0) {
				firstNumber /= i;
				secondNumber /= i;
				GCD *= i;
			}
		}
		println(GCD);
		
	}

}