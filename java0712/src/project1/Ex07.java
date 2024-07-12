package project1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex07 {
	
	public static void showMain() {
		System.out.println("---------------------------------------");
		System.out.println("1.로그인 | 2. 회원가입 | 3.예금/출금 | 4. 종료");
		System.out.println("---------------------------------------");
	}
	
	public static void showInfo() {
		System.out.println("---------------------------------------");
		System.out.println("1.예금 | 2. 출금 | 3.잔고 | 4. 종료");
		System.out.println("---------------------------------------");
	}
	
	public static String inputString(String msg, Scanner sc) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
	
	public static int inputNumber(String msg, Scanner sc) {
		System.out.print(msg);
		int number = 0;
		try {
			number = Integer.parseInt(sc.nextLine());
		}catch(Exception e) {
			System.out.println("숫자가 아님");
		}
		return number;
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean runMain = true;
		boolean runInfo = true;
		
		String id = null;
		String pwd = null;
		
		ArrayList<Member> userList = new ArrayList<Member>();
		
//		userList.add(new Member("","","","java","12345"));
		
		Member user = new Member("java","java","java","java","12345");
		
		while(runMain) {	//	메인화면
			showMain();
			int mainSelection = Integer.parseInt(inputString("선택>", scanner));
			switch(mainSelection) {
			case 1:	//	로그인
				System.out.println("로그인 처리");
				id = inputString("아이디: ", scanner);
				if(id.equals(user.id)) {
					
				}else {
					System.out.println("로그인 실패: 아이디가 틀림");
					break;
				}
				pwd = inputString("패스워드: ", scanner);
				if(pwd.equals(user.pwd)){
					System.out.println("로그인 성공");
				}else {
					System.out.println("로그인 실패: 패스워드가 틀림");
				}
				
				break;
			case 2:	//	회원가입
				System.out.println("회원가입");
				System.out.println("[필수 정보 입력]");
				Member userInfo = new Member(
						inputString("1. 이름: ",scanner),
						inputString("2. 주민번호 앞 6자리:",scanner),
						inputString("3. 전화번호:",scanner),
						inputString("4. 아이디:",scanner),
						inputString("5. 비밀번호:",scanner));
				System.out.println("입력된 내용");
				System.out.println(userInfo.toString());
//				System.out.println("1. 이름:" + userInfo[0]);
//				System.out.println("2. 주민번호 앞 6자리: " + userInfo[1]);
//				System.out.println("3. 전화번호: " + userInfo[2]);
				break;
			case 3:	//	예금 출금 화면, userLoginInfo
				System.out.println("예금 출금");
				runInfo = true;
				while(runInfo) {
					showInfo();
					int infoSelection = Integer.parseInt(inputString("선택>", scanner));
					switch(infoSelection) {
					case 1:	//	예금
						System.out.print("예금액>");
						user.balance+=Integer.parseInt(scanner.nextLine());
						break;
					case 2:	//	출금
						System.out.println("출금액>");
						user.balance-=Integer.parseInt(scanner.nextLine());
						break;
					case 3:	//	잔고확인
						System.out.println("잔고>"+user.balance);
						break;
					case 4:	//	종료
						runInfo = false;
						break;
					}
				}
				System.out.println("예금/출금 프로그램 종료");
				break;
			case 4:	//	종료
				runMain = false;
				break;
			}
		}
		System.out.println("프로그램 전체 종료");
		scanner.close();
	}
}
