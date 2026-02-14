package midtermPractice;

import acm.program.ConsoleProgram;

public class WordGame extends ConsoleProgram{
	public void run(){
		runTests();
	}

	private boolean canGet(String src, String target){
		//YOUR CODE GOES HERE
		for (int i=0;i<target.length();i++){
			char c = target.charAt(i);
			if (src.indexOf(c) == -1) {
				return false;
			}
			src = src.substring(0, src.indexOf(c)) + src.substring(src.indexOf(c)+1);
		}
		return true;
	}
	
	private void runTests() {
		String[] tests = {"gamarjoba", "baro", "abba", "bbb", "luka", "akul", "jayce", "yay", 
						  "mcr", "mgk", "sneak", "snake", "dubadub", "babudu", "kappa", "pack"};
		boolean[] results = {true, false, true, false, false, true, true, false};
		int passed = 0;
		for (int i=0;i<tests.length;i+=2){
			String in1 = tests[i];
			String in2 = tests[i+1];
			boolean expectedOutput = results[i/2];
			boolean result = canGet(in1, in2);
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