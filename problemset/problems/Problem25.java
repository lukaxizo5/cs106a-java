import acm.program.ConsoleProgram;

public class Problem25 extends ConsoleProgram {
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
		int LCM = GCD * firstNumber * secondNumber;
		println(LCM);
		
	}

}
