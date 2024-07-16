package dp;

import java.util.Vector;

public class Course {
	private String id;
	private String name;
	private int numOfStudent = 0;
	private Vector<Student> students;
	
	
	
	public Course(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.students = new Vector<Student>();
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", numOfStudent=" + numOfStudent + "]";
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addStudent(Student student){
		students.add(student);
		numOfStudent++;
	}
	
	public Vector<Student> getStudent() {
		return students;
	}
	
	public void deleteStudent(Student student){
		students.remove(student);
		numOfStudent--;
	}
	
	public String getInfo() {
		String str = "";
		for(int i = 0; i < students.size(); i++) {
			str += students.get(i).getName();
			if(i != students.size() - 1) {
				str += ", ";
			}
		}
		return ("Course id = " + id + ", name = " + name + ", students = " + str);
	}
}
