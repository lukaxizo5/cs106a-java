import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class Problem50 extends ConsoleProgram{
	public void run() {
		String s = readLine();
		int ans = 0;
		StringTokenizer tokenizer = new StringTokenizer(s);
		
		while (tokenizer.hasMoreTokens()) {
			String currToken = tokenizer.nextToken();
			ans++;
		}
		println(ans);
	}
}
