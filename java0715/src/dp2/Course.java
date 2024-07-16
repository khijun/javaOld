package dp2;

import java.util.Vector;

public class Course {
	private Vector<Transcript> transcripts;
	private String name;
	
	public Course(String name) {
//		super();
		transcripts = new Vector<Transcript>();
		this.setName(name);
	}
	
	public void addTranscript(Transcript transcript) {
		transcripts.add(transcript);
		return;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public Vector<Student> getStudents() {
		Vector<Student> students = new Vector<Student>();
		for(Transcript tsp : transcripts) {
			students.add(tsp.getStudent());
		}
		return students;
	}
	
	public Vector<Transcript> getTranscript(){
		return transcripts;
	}
	
	public void printGrade() {
		System.out.printf("학생들의 %s성적: \n",this.getName());
		for(Transcript tsp : this.getTranscript()) {
			System.out.printf("%s: %s\n",tsp.getStudent().getName(),tsp.getGrade());
		}
	}
	
}
