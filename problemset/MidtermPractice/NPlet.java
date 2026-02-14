package midtermPractice;

import acm.program.ConsoleProgram;

public class NPlet extends ConsoleProgram{
	public void run(){
		runTests();
	}
	
	private String removeNPlets(String s, int n){
		//YOUR CODE GOES HERE
		while (hasNPlet(s,n) != -1) {
			s = s.substring(0, hasNPlet(s,n)) + s.substring(hasNPlet(s,n)+n); 
		}
		return s;
	}

	private int hasNPlet(String s, int n) {
		//all candidates check
		for (int i=0;i<=s.length()-n;i++){
			boolean b = true;
			//candidate check
			for (int j=i;j<=i+n-2;j++){
				if (s.charAt(j)!=s.charAt(j+1)) {
					b = false;
					break;
				}
			}
			if (b) return i;
		}
		return -1;
	}

	private void runTests() {
		String[] tests1 = {"aaaabbbccde", "aabbbaki", "kookoorokkoko", "bummuuuumm", "abbad", "yeedaabbbaddeeeeyy"};
		int[] tests2 = {3, 3, 2, 4, 3, 3};
		String[] results = {"accde", "ki", "rko", "bu", "abbad", ""};
		int passed = 0;
		for (int i=0;i<tests1.length;i++){
			String in1 = tests1[i];
			int in2 = tests2[i];
			String expectedOutput = results[i];
			String result = removeNPlets(in1, in2);
			if (expectedOutput.equals(result)) {
				passed++;
				println("TEST " + (i+1) +  " PASSED");
			}
			else {
				println("TEST " + (i+1) +  " FAILED");
			}
		}
		println("PASSED " + (passed) + " TESTS OUT OF " + (tests1.length));
	}
}