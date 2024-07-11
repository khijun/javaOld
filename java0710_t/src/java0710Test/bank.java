package java0710Test;

import java.util.ArrayList;
import java.util.Scanner;

public class bank {
	
	final static int MIN = 0;
	final static int MAX = 100000000;
	
	public static void main(String[] args) {

		
		ArrayList<user> userList = new ArrayList<user>();
		Scanner sc = new Scanner(System.in);
		
		int selection = 0;
		boolean flagMain = true;
		boolean flagUserI = true;
		user loginedUser = null;
		
		userList.add(new user("kim","123",10000));
		
		while(flagMain) { //메인
			System.out.printf("\n----------------------------------------\n");
			System.out.println(loginedUser == null?
				"1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료":
				"1.로그아웃 | 2.회원탈퇴 | 3.예금/출금 | 4.종료");
			System.out.println("----------------------------------------");
			selection = input.getNumber("입력>", sc,1,4);
			switch(selection) {
			case 1:
				if(loginedUser == null)
					loginedUser = login(sc, userList);
				else
					loginedUser = null;
				break;
			case 2:
				if(loginedUser == null)
					register(sc, userList);
				else if(user.checkPwd(input.getString("비밀번호 입력",sc),loginedUser)) {
					userList.remove(loginedUser);
					loginedUser = null;
					System.out.println("회원탈퇴 완료");
				}
				break;
			case 3:
				if(loginedUser == null) {
					System.out.println("로그인 먼저 해주세요");
					break;
				}	
				flagUserI = true;
				while(flagUserI) { //유저 개인 인터페이스
					System.out.printf("\n-----------------------------\n");
					System.out.println("1.예금 | 2.출급 | 3.잔고 | 4.종료");
					System.out.println("-----------------------------");
					selection = input.getNumber("입력>", sc, 1, 4);
					switch(selection) {
					case 1:
						user.deposit(input.getNumber("입금할 금액을 입력해주세요>", sc),loginedUser);
						break;
					case 2:
						user.withdraw(input.getNumber("출금할 금액을 입력해주세요>", sc),loginedUser);
						break;
					case 3:
						System.out.printf("%d원 남았습니다.\n",user.getMoney(loginedUser));
						break;
					case 4:
						System.out.println("이전 화면으로 돌아갑니다.");
						flagUserI = false;
						break;
					}
				}
				break;
			case 4:
				flagMain = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
	
	public static user login(Scanner sc,ArrayList<user> userList) {
		String inputStr = "";
		inputStr = input.getString("아이디를 입력해주세요>",sc);
		for(user usr : userList) {
			if(inputStr.equals(user.getId(usr))) {
				inputStr = input.getString("비밀번호를 입력해주세요",sc);
				if(user.checkPwd(inputStr, usr)) {
					return usr;
				}
				return null;
			}
		}
		System.out.println("일치하는 아이디 없음");
		return null;
	}
	
	
	public static void register(Scanner sc,ArrayList<user> userList) {
		String id = input.getString("아이디를 입력해주세요>",sc);
		
		/* 중복검사 */
		
		String pwd = input.getString("비밀번호를 입력해주세요",sc);
		userList.add(new user(id,pwd,0));
	}
}
