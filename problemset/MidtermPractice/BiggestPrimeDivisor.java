package midtermPractice;

import acm.program.ConsoleProgram;

public class BiggestPrimeDivisor extends ConsoleProgram{
	public void run(){
		runTests();
	}
	
	private int getBiggestPrimeDivisor(int n){
		// YOUR CODE GOES HERE
		int ans = 0;
		for(int i=2;i<=n;i++){
			if (n%i==0) {
				if (isPrime(i)) ans = i;
			}
		}
		return ans;
	}
	
	private boolean isPrime(int x){
		for (int i=2;i<x;i++){
			if (x%i==0) return false;
		}
		return true;
	}
	
	private void runTests() {
		int[] tests = {7, 12, 60, 25, 1119, 2024, 2793, 9541};
		int[] results = {7, 3, 5, 5, 373, 23, 19, 47};
		int passed = 0;
		for (int i=0;i<tests.length;i++){
			int input = tests[i];
			int expectedOutput = results[i];
			int result = getBiggestPrimeDivisor(input);
			if (expectedOutput == result) {
				passed++;
				println("TEST " + (i+1) +  " PASSED");
			}
			else {
				println("TEST " + (i+1) +  " FAILED");
			}
		}
		println("PASSED " + (passed) + " TESTS OUT OF " + (tests.length));
	}
}