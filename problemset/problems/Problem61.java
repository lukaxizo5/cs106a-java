import acm.program.ConsoleProgram;

public class Problem61 extends ConsoleProgram {
	public void run() {
		int m = readInt();
		int n = readInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		for (int i=0;i<n-1;i++) {
			for (int j=i+1;j<n;j++){
				if (a[i]+a[j] == m) {
					println(a[i] + " + " + a[j]);
				}
			}
		}
	}

}
