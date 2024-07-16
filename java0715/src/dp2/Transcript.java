package dp2;

public class Transcript {
	private Course course;
	private Student student;
	private String date;
	private String grade;
	
	public Transcript(Course course, Student student, String date) {
		this(course, student, date, "F");
	}
	
	public Transcript(Course course, Student student, String date, String grade) {
		this.course = course;
		this.student = student;
		this.date = date;
		this.grade = grade;
		course.addTranscript(this);
	}
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "강의명: " + course + ", 날짜: " + date + ", 등급: " + grade;
	}
	
}
