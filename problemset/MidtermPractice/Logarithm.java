package midtermPractice;
import acm.program.*;

public class Logarithm extends ConsoleProgram {
	public void run () {
		runTests();
	}

	private int log(int n, int m) {
		// YOUR CODE GOES HERE
		int count = 0;
		while(m/n>0){
			m/=n;
			count++;
		}
		return count;
	}
	
	private void runTests() {
		int[] tests = {2, 4, 2, 8, 5, 25, 5, 26, 7, 2744, 10, 11667};
		int[] results = {2, 3, 2, 2, 4, 4};
		int passed = 0;
		for (int i=0;i<tests.length;i+=2){
			int in1 = tests[i];
			int in2 = tests[i+1];
			int expectedOutput = results[i/2];
			int result = log(in1, in2);
			if (expectedOutput == result) {
				passed++;
				println("TEST " + (i/2+1) +  " PASSED");
			}
			else {
				println("TEST " + (i/2+1) +  " FAILED");
			}
		}
		println("PASSED " + (passed) + " TESTS OUT OF " + (tests.length)/2);
	}
}
