import acm.program.ConsoleProgram;

public class Problem57 extends ConsoleProgram{
	public void run(){
		String s1 = readLine();
		String s2 = readLine();
		println(CheckAnagram(s1, s2));
	}

	private boolean CheckAnagram(String s1, String s2) {
		int[] a1 = new int[26];
		int[] a2 = new int[26];
		for (int i = 0; i < s1.length(); i++){
			a1[s1.charAt(i)-'a']++;
		}
		for (int i = 0; i < s2.length(); i++){
			a2[s2.charAt(i)-'a']++;
		}
		for (int i = 0; i < 26; i++){
			if (a1[i] != a2[i]) return false;
		}
		return true;
	}

}
