import acm.program.ConsoleProgram;

public class Problem56 extends ConsoleProgram{
	public void run(){
		int n = readInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		int min = a[0];
		int mindex = 0;
		for (int i = 0; i < n; i++){
			min = a[i];
			mindex = i;
			for (int j = i + 1; j < n; j++){
				if (a[j] < min){
					min = a[j];
					mindex = j;
				}
			}
			swaps(a, i, mindex);
		}
		for (int i=0;i<n;i++){
			print(a[i]+" ");
		}
	}

	private void swaps(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}