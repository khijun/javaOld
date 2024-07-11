package java0710Test;

public class user {
	private int money;
	private String pwd;
	private String id;
	public user() {

	}
	public user(String id, String pwd, int money) {
		this.id = id;
		this.pwd = pwd;
		this.money = money;
	}
	public static String getId(user usr) {
		return usr.id;
	}
	private static String getPwd(user usr) {
		return usr.pwd;
	}
	public static boolean checkPwd(String pwd, user usr) {
		if(user.getPwd(usr).equals(pwd)) {
			System.out.println("비밀번호 일치");
			return true;
		}
		else {
			System.out.println("비밀번호 불일치");
			return false;
		}
	}
	public static void deposit(int value, user usr) {	//	입금
		usr.money += value;
		System.out.printf("%d원 입금 완료.", value);
	}
	public static void withdraw(int value, user usr){	//	출금
		if(value > usr.money) {
			System.out.println("잔액 부족!");
			return;
		}
		System.out.printf("%d원 출금 완료.", value);
		usr.money -= value;
	}
	public static int getMoney(user usr) {
		return usr.money;
	}
}
