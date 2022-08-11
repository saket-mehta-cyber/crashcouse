import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//Make necessary changes to the Student class
class Student{
	
	private Integer studentId;
	private String studentName;
	private Integer studentSemester;

    public Student(String studentName, Integer studentSemester, Integer studentId) {
		this.studentName = studentName;
		this.studentId = studentId;
		this.studentSemester = studentSemester;
	}

	//Getters and setters
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentSemester() {
		return studentSemester;
	}

	public void setStudentSemester(Integer studentSemester) {
		this.studentSemester = studentSemester;
	}
}


class Tester {
	public static void main(String[] args) {
	
		Student student1 = new Student("Ron", 1, 101);
		Student student2 = new Student("Angela", 9, 102);
		Student student3 = new Student("Hazel", 5, 103);
		Student student4 = new Student("David", 3, 104);
		Student student5 = new Student("Alan", 4, 105);
		Student student6 = new Student("Hazel", 5, 103);
		Student student7 = new Student("Ron", 1, 101);

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);
		studentList.add(student6);
		studentList.add(student7);
		
		//Implement your logic here
	}
}
