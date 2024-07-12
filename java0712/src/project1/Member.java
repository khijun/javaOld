package project1;

public class Member {
	String name;
	String ssn;	//	주민번호 6자리
	String phone;
	String id;
	String pwd;
	int balance;
	
	public Member(String name, String ssn, String phone, String id, String pwd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.id = id;
		this.pwd = pwd;
		balance = 0;
	}
	
	public Member(String name, String ssn, String phone) {
		this(name, ssn, phone, "", "");
	}
	
	public Member() {
		
	}

	@Override
	public String toString() {
		return "1. 이름: " + name + "\t2. 주민번호: " + ssn + "\t3. 전화번호: " + phone + "\n";
	}
	
	
	
}
