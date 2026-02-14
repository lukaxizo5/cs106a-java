import acm.program.ConsoleProgram;

public class Problem15 extends ConsoleProgram {
	public void run() {
		int firstNumber = readInt("Insert first number: ");
		int secondNumber = readInt("insert second number: ");
		double arithmeticMean = (double)(firstNumber+secondNumber) / 2;
		println(arithmeticMean);
	}

}
