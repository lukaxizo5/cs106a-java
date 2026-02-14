import acm.program.ConsoleProgram;

public class Problem47 extends ConsoleProgram {
	public void run() {
		String s = readLine();
		println(isPalindrome(s));
	}

	private boolean isPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
		}
		return true;
	}
}