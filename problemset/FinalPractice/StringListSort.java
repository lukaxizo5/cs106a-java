package finalsPractice;

import java.util.ArrayList;
import java.util.Comparator;

import acm.program.ConsoleProgram;

public class StringListSort extends ConsoleProgram{
	public void run() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("luka");
		a.add("xvliki");
		a.add("a");
		a.add("meqanika");
		a.sort(new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				if (arg0.length() > arg1.length()) {
					return -1;
				}
				if (arg0.length() == arg1.length()) {
					return 0;
				}
				return 1;
			}
			
		});
		for (int i = 0; i < a.size(); i++) {
			println(a.get(i) + " ");
		}
	}
}
