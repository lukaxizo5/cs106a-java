import java.util.Arrays;

import acm.program.ConsoleProgram;

public class Problem58 extends ConsoleProgram{
	public void run() {
		int n = readInt();
		int[][] a = new int[n][n];
		int[] b = new int[n*n];
		Arrays.fill(b, 0);
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				a[i][j] = readInt();
				if (a[i][j] >= 1 && a[i][j] <= n*n) {
					b[a[i][j]-1]++;
				}
			}
		}
		for (int i=0;i<n*n;i++) {
			if (b[i] != 1){
				println("Not a magic matrix");
				return;
			}
		}
		println("Magic Matrix!");
	}

}
