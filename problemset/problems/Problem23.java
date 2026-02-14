import acm.program.ConsoleProgram;

public class Problem23 extends ConsoleProgram {
	public void run() {
		int n = readInt("Insert natural number: ");
		int sum = n*(n+1)/2;
		println(sum);
	}

}