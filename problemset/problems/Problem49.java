import acm.program.ConsoleProgram;

public class Problem49 extends ConsoleProgram {
	public void run() {
		String s = readLine();
		println(stringToInteger(s));
	}

	private int stringToInteger(String s) {
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			ans += ((int)(s.charAt(i)) - 48);
			if (i != s.length() - 1) {
				ans *= 10;
			}
		}
		return ans;
	}
	
}