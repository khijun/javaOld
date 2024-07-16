package dp2;

import java.util.Vector;

public class Student {
	private Vector<Transcript> transcripts;
	private String name;
	
	public Student(String name) {
		super();
		transcripts = new Vector<Transcript>();
		this.setName(name);
	}
	
	public void registerCourse(Course course,String date, String grade) {
		transcripts.add(new Transcript(course,this,date, grade));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<Course> getCourse() {
		Vector<Course> courses = new Vector<Course>();
		for(Transcript tsp : transcripts) {
			courses.add(tsp.getCourse());
		}
		return courses;
	}
	@Override
	public String toString() {
		return name;
	}
	
	public Vector<Transcript> getTranscript(){
		return transcripts;
	}
	
	public void setGrade(Course course,String grade) {
		for(Transcript a : transcripts) {
			if(a.getCourse().equals(course)) {
				a.setGrade(grade);
			}
		}
	}
	
}
