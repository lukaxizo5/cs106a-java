import java.util.ArrayList;

import acm.program.ConsoleProgram;

public class Problem60 extends ConsoleProgram{
	public void run() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int n = readInt();
		if (n == -1) {
			return;
		}
		while (n != -1) {
			a.add(n);
			n = readInt();
		}
		for (int i = a.size() - 1; i >= 0; i--) {
			print(a.get(i) + " ");
		}
	}
}
