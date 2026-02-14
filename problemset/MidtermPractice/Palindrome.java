package midtermPractice;

import acm.program.ConsoleProgram;

public class Palindrome extends ConsoleProgram{
	public void run(){
		runTests();
	}

	private boolean isPalindrome(int n){
		// YOUR CODE GOES HERE
		int x = n;
		int res = 0;
		while (x>0) {
			int y = x%10;
			res = res * 10 + y;
			x = x/10; 
		}
		return res == n;
		/*
		if (res == n) return true;
		return false;
		*/
	}
	
	private void runTests() {
		int[] tests = {1, 5, 19, 21, 77, 121, 898, 328327, 1234321, 99987999};
		boolean[] results = {true, true, false, false, true, true, true, false, true, false};
		int passed = 0;
		for (int i=0;i<tests.length;i++){
			int input = tests[i];
			boolean expectedOutput = results[i];
			boolean result = isPalindrome(input);
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