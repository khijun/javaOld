package iterator_ex1;

import java.util.Iterator;

public class Students implements Iterable<Student>{
	private Student[] students;
	private int last = 0;
	
	@Override
	public Iterator<Student> iterator() {
		return new StudentsIterator(this);
	}
	
	public Students(int max) {
		this.students = new Student[max];
	}
	
	public Student getStudentAt(int index) {
		return students[index];
	}
	
	public void appendStudent(Student student) {
		students[last++] = student;
	}
	
	public int getLength() {
		return last;
	}
}
