import acm.program.ConsoleProgram;

public class Problem51 extends ConsoleProgram{
	public void run(){
		String s = readLine();
		String ans = deleteDuplicates(s);
		println(ans);
	}

	private String deleteDuplicates(String s) {
		String ans = "";
		for (int i=0;i<s.length();i++){
			if (!contains(ans,s.charAt(i))) ans+=s.charAt(i);
		}
		return ans;
	}

	private boolean contains(String ans, char charAt) {
		for (int i=0;i<ans.length();i++){
			if (ans.charAt(i)==charAt) return true;
		}
		return false;
	}
	
}
