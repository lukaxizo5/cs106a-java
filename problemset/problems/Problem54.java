import java.util.Arrays;

import acm.program.ConsoleProgram;

public class Problem54 extends ConsoleProgram{
	public void run(){
		int n = readInt();
		int[] a = new int[n]; 
		for (int i=0; i<n; i++){
			a[i] = readInt();
		}
		Arrays.sort(a);
		println("Max number is: " + a[n-1]);
		println("Second max number is: " + a[n-2]);
	}

}
