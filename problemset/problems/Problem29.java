import acm.program.ConsoleProgram;

public class Problem29 extends ConsoleProgram {
	public void run() {
		int n = readInt("Insert natural number: ");
		int fib1 = 0;
		int fib2 = 1;
		int fib = 0;
		while (n > 2) {
			fib = (fib1 + fib2);
			fib1 = fib2;
			fib2 = fib;
			n--;
		}
		println(fib);
	}
}