import acm.program.ConsoleProgram;

public class Problem46 extends ConsoleProgram {
	public void run() {
		String s = readLine();
		char c = getMax(s);
		println(c);
	}

	private char getMax(String s) {
		int max = 0;
		char ans = '0';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int cnt = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == c) cnt++;
			}
			if (Math.max(cnt, max) == cnt) {
				ans = c;
			}
		}
		
		return ans;
	}
}
