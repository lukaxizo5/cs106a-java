import acm.program.ConsoleProgram;

public class Problem30 extends ConsoleProgram {
	public void run() {
		int n = readInt("Insert natural number: ");
		int reverseN = 0;
		while (n != 0) {
			reverseN += n % 10;
			n/=10;
			if (n == 0) break;
			reverseN*=10;
		}
		println(reverseN);
	}
}