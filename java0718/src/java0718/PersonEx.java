package java0718;

public class PersonEx {
	public static void main(String[] args) {
		Driver driver = new Driver();
		Role role = driver;
		role.doIt();
		role = new Worker();
		role.doIt();
		
		Worker worker = null;
		if(role instanceof Worker) {
			worker = (Worker) role;
		}
		worker.doIt();
		
		Person p = new Person();
		p.setRole(new Driver());
		p.doIt();
		p.setRole(new Worker());
		p.doIt();
	}
}
