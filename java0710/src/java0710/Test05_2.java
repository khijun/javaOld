package java0710;

import java.util.Scanner;

@SuppressWarnings("resource")
public class Test05_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int selection = 0;
		int value = 0;
		boolean flag = true;
		while(flag) {
			System.out.printf("\n-----------------------------\n");
			System.out.println("1.예금 | 2.출급 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			selection = Integer.parseInt(sc.nextLine());
			switch(selection) {
			case 1:
				System.out.printf("예금액>");
				value += Integer.parseInt(sc.nextLine());
				break;
			case 2:
				System.out.printf("출금액>");
				value -= Integer.parseInt(sc.nextLine());
				break;
			case 3:
				System.out.printf("잔고>%d",value);
				break;
			case 4:
				flag = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}

