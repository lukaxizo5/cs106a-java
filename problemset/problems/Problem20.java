import acm.program.ConsoleProgram;

public class Problem20 extends ConsoleProgram {
	public void run() {
		int n = readInt("Insert first number: ");
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int j = readInt("Insert number: ");
			sum+=j;
		}
		println(sum);
	}

}