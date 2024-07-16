package dp2;

public class Main2 {

	public static void main(String[] args) {
		Course java = new Course("자바");
		Course python = new Course("파이썬");
		Course cplus = new Course("C++");
		
		Student minsu = new Student("민수");
		Student gildong = new Student("길동");
		
		minsu.registerCourse(java, "2024년 2학기", "A");
		minsu.registerCourse(python, "2024년 2학기", "B+");
		minsu.registerCourse(cplus, "2024년 2학기", "A+");
		
		gildong.registerCourse(java, "2024년 2학기", "B-");
		gildong.registerCourse(python, "2024년 2학기", "C");
		
		System.out.print(minsu.getName() + " 학생이 수강하는 강의: ");
		System.out.println(minsu.getCourse());
		
		System.out.print(java.getName() + " 강의를 수강하는 학생: ");
		System.out.println(java.getStudents());
		
		System.out.print(minsu.getName() + " 학생의 성적 이력: ");
		System.out.println(minsu.getTranscript());
		
		minsu.setGrade(java, "A+");
		System.out.print(minsu.getName() + " 학생의 성적 이력: ");
		System.out.println(minsu.getTranscript());
		
		
		java.printGrade();
		System.out.println(java.getTranscript());
	}

}
