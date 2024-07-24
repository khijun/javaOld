package iterator_ex1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StudentsIterator implements Iterator<Student>{
	private Students students;
	private int index;
	
	
	public StudentsIterator(Students students) {
		this.students = students;
		this.index = 0;
	}


	@Override
	public boolean hasNext() {
		return index < students.getLength()?true:false;
	}


	@Override
	public Student next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return this.students.getStudentAt(index++);
	}
	
}
