import acm.program.ConsoleProgram;

public class Problem32 extends ConsoleProgram {
	public void run() {
		for (int i = 2; i < 10000; i++) {
			if (checkPrime(i)) {
				println(i);
			}
		}
	}
	
	private boolean checkPrime(int n) {
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}