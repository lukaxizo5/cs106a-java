package finalsPractice;

import java.util.HashMap;

import acm.program.ConsoleProgram;

public class ValidateTeachers extends ConsoleProgram{
	public void run() {
		HashMap<String,String> studentTeachers = new HashMap<String, String>();
		studentTeachers.put("luka", "saba");
		studentTeachers.put("saba", "nika");
		studentTeachers.put("nika", "luka"); //false case
		println(validateTeachers(studentTeachers));
	}
	
	private boolean validateTeachers(HashMap<String, String> hm) {
		for (String student : hm.keySet()) {
			String s = hm.get(student);
			while (hm.containsKey(s)) {
				s = hm.get(s);
				if (s.equals(student)) return false;
			}
		}
		return true;
	}
}
