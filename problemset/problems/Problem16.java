import acm.program.ConsoleProgram;

public class Problem16 extends ConsoleProgram {
	public void run() {
		int firstNumber = readInt("Insert first number: ");
		int secondNumber = readInt("insert second number: ");
		int thirdNumber = readInt("insert second number: ");
		double harmonicMean = 1.0 / ((double)(1/(double)firstNumber) + (double)(1/(double)secondNumber) + (double)(1/(double)thirdNumber));
		println(harmonicMean);
	}

}