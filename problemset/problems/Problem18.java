import acm.program.ConsoleProgram;

public class Problem18 extends ConsoleProgram {
	public void run() {
		int firstNumber = readInt("Insert first number: ");
		int secondNumber = readInt("insert second number: ");
		println(Math.max(firstNumber,secondNumber));
	}

}