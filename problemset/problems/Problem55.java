import java.util.Arrays;

import acm.program.ConsoleProgram;

public class Problem55 extends ConsoleProgram{
	public void run(){
		int n = readInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
			b[i] = a[i];
		}
		Arrays.sort(b);
		for (int i = 0; i < n; i++){
			if (a[i] != b[i]) {
				println("Not Sorted");
				return;
			}
		}
		println("Sorted");
	}	
}
