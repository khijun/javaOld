package dp;

public class Professor {
	private Professor advisor;
	
	public void advice(String msg) {
		System.out.println(msg);
	}

	public Professor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Professor advisor) {
		this.advisor = advisor;
	}
}
