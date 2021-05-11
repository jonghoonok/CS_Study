package ch01;

import java.util.ArrayList;

public class GenerateGradeReport {

	School school = School.getInstance();
	
	public static final String TITLE = " ������ ���� \t\t\n";
	public static final String HEADER = " �̸�  |  �й�  |��������| ����   \n";
	public static final String LINE = "-------------------------------------\n";
	
	private StringBuffer buffer = new StringBuffer();
	
	public String getReport() {
		
		ArrayList<Subject> subjectList = school.getSubjectList();
		
		for(Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		return buffer.toString();
	}
	
	public void makeHeader(Subject subject){
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE );
		buffer.append(GenerateGradeReport.HEADER );
		buffer.append(GenerateGradeReport.LINE);
	} 

	public void makeBody(Subject subject) {
		
		ArrayList<Student> studentList = subject.getStudentList();
		
		for(Student student : studentList) {
			buffer.append(student.getStudentName());
			buffer.append(" | ");
			buffer.append(student.getStudentId());
			buffer.append(" | ");
			buffer.append(student.getMajor().getSubjectName() + "\t");
			buffer.append(" | ");
			
			getScoreGrade(student, subject);  //�л��� �ش���� ���� ���
			buffer.append("\n");
			buffer.append(LINE);
		}
	}
	
	public void getScoreGrade(Student student, Subject subject) {
		
		ArrayList<Score> scoreList = student.getScoreList();
		int majorId = student.getMajor().getSubjectId();
		
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation(), new PassFailEvaluation()};
		
		for(Score score : scoreList) {
			if(score.getSubject().getSubjectId() == subject.getSubjectId()) {
				String grade;
				if(subject.getGradeType() == Define.PF)
					grade = gradeEvaluation[Define.PF].getGrade(score.getPoint());
				else {
					if(score.getSubject().getSubjectId() == majorId)
						grade = gradeEvaluation[Define.STOF].getGrade(score.getPoint());
					else
						grade = gradeEvaluation[Define.ATOF].getGrade(score.getPoint());
				}
				buffer.append(score.getPoint());
				buffer.append(":");
				buffer.append(grade);
				buffer.append(" | ");
				
			}
		}
		
	}
	
	public void makeFooter(){
		buffer.append("\n");
	}

}
