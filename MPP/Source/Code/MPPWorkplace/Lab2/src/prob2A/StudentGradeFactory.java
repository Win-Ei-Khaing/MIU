package prob2A;

public class StudentGradeFactory {
public static void newStudent(String name) {
	if(name == null) 
		throw new IllegalArgumentException("Student name cannot be null");
	Student s=new Student("Win");
	
	GradeReport gr=new GradeReport(s);
	s.setGradeReport(gr);
}
}
