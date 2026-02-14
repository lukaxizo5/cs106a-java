import acm.program.ConsoleProgram;

public class Problem31 extends ConsoleProgram {
	public void run() {
		int n = readInt("Insert natural number: ");
		if (checkPrime(n)) {
			println("Prime!");
		}
		else {
			println("Composite!");
		}
	}
	
	private boolean checkPrime(int n) {
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}