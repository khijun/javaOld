package project2Swing;

import java.io.Serializable;

public class Member implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String ssn;   // 주민번호 6자리 패스워드
	private String phone;
	private int balance;
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", ssn=" 
				+ ssn + ", phone=" + phone + ", balance=" + balance + "]";
	}

	public Member(String name, String ssn, String phone, int balance) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.balance = balance;
	}
	
	public Member(String name, String ssn, String phone) {
		this(name, ssn, phone, 0);
	}
	
	public Member() {}
	
	public void deposit(int deposit) {	// 입금
		balance += deposit;
	}
	
	public void withdraw(int withdraw) {	// 출금
		if(withdraw > balance) {
			System.out.println("잔액 부족");
			return;
		}
		if(withdraw<=0) {
			System.out.println("0이하의 금액은 불가능합니다");
			return;
		}
		balance -= withdraw;
	}
	
}