package finalsPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class School {
	
	private ArrayList<String> teachers;
	private ArrayList<String> pupils;
	private HashMap<String, ArrayList<String>> teacherSubjects;
	private HashMap<String, ArrayList<String>> pupilSubjects;
	
	public School() {
		teachers = new ArrayList<String>();
		pupils = new ArrayList<String>();
		teacherSubjects = new HashMap<String, ArrayList<String>>();
		pupilSubjects = new HashMap<String, ArrayList<String>>();
	}
	
	public void addTeacher(String teacher) {
		teachers.add(teacher);
		teacherSubjects.put(teacher, new ArrayList<String>());
	}
	
	public void addSubject(String teacher, String subject) {
		ArrayList<String> subjects = teacherSubjects.get(teacher);
		subjects.add(subject);
		teacherSubjects.put(teacher, subjects);
	}
	
	public void addPupil(String pupil, String subject) {
		pupils.add(pupil);
		if (pupilSubjects.containsKey(pupil)) {
			pupilSubjects.get(pupil).add(subject);
		}
		else {
			pupilSubjects.put(pupil, new ArrayList<String>());
			ArrayList<String> subjects = pupilSubjects.get(pupil);
			subjects.add(subject);
		}
	}
	
	public Iterator<String> getTeachers(String pupil){
		ArrayList<String> arr = pupilSubjects.get(pupil);
		ArrayList<String> teachersOfPupil = new ArrayList<String>();
		for (int i = 0; i < arr.size(); i++) { 
			for (int j = 0; j < teachers.size(); j++) {
				if (teacherSubjects.get(teachers.get(j)).contains(arr.get(i))) {
					if (!teachersOfPupil.contains(teachers.get(j))) {
						teachersOfPupil.add(teachers.get(j));
					}
				}
			}
		}
		return teachersOfPupil.iterator();
	}
	
	public Iterator<String> getPupils(String teacher){
		ArrayList<String> arr = teacherSubjects.get(teacher);
		ArrayList<String> pupilsOfTeacher = new ArrayList<String>();
		for (int i = 0; i < arr.size(); i++) { 
			for (int j = 0; j < pupils.size(); j++) {
				if (pupilSubjects.get(pupils.get(j)).contains(arr.get(i))) {
					if (!pupilsOfTeacher.contains(pupils.get(j))) {
						pupilsOfTeacher.add(pupils.get(j));
					}
				}
			}
		}
		return pupilsOfTeacher.iterator();
	}
	
	public void removeTeacher(String teacher) {
		teachers.remove(teacher);
	}
	
}