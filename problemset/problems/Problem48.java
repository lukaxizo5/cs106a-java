import acm.program.ConsoleProgram;

public class Problem48 extends ConsoleProgram {
	public void run() {
		String s = readLine();
		getStats(s);
	}

	private void getStats(String s) {
		String collector = "";
		for (int i = 0; i < s.length(); i++) {
			int cnt = 0;
			Character c = s.charAt(i);
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					cnt++;
				}
			}
				if (!collector.contains(""+c)) {
					println(s.charAt(i) + " " + cnt);
				}
				collector+=c;
		}
	}
	
}