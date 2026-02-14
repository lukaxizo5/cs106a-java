import acm.program.ConsoleProgram;

public class Problem45 extends ConsoleProgram {
	public void run() {
		String s = readLine();
		char c = readLine().charAt(0);
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) ans++;
		}
		println(ans);
	}
}
