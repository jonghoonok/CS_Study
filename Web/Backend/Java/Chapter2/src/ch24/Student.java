package ch24;

import java.util.ArrayList;

public class Student {
	int studentNum = 1000;
	String studentName;
	ArrayList<Subject> subjectList;
	
	public Student(int studentNum, String studentName) {
		this.studentNum = studentNum;
		this.studentName = studentName;

		subjectList = new ArrayList<Subject>();
	}
	
	public void addSubject(String name, int score) {
		Subject subject = new Subject();
		
		subject.setName(name);
		subject.setScore(score);
		
		subjectList.add(subject);
	}
	
	public void showStudentInfo() {
		int total = 0;
		
		for (Subject subject : subjectList) {
			total += subject.getScore();
			System.out.println(studentName + " �л��� " + subject.getName() + " ������ ������ " + subject.getScore() + " �� �Դϴ�.");
		}
		System.out.println(studentName + " �л��� ������ " + total + " �� �Դϴ�.");
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
}
