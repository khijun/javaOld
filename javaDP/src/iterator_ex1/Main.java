package iterator_ex1;

public class Main {
	public static void main(String[] args) {
		Students students = new Students(3);
		students.appendStudent(new Student("kim",240724,50.5));
		students.appendStudent(new Student("park",240724,70.7));
		students.appendStudent(new Student("lee",240724,90.9));
	}
}
