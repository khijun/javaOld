package du;

public class Account {
	private int id;
	private String name;
	private String ssn;
	private String tel;
	private int balance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Account(int id, String name, String ssn, String tel, int balance) {
		this.id = id;
		this.name = name;
		this.ssn = ssn;
		this.tel = tel;
		this.balance = balance;
	}
	public Account(String name, String ssn, String tel) {
		this(-1,name, ssn, tel,0);
	}
	
	
}
