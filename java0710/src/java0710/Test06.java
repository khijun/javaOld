package java0710;

import java.util.Scanner;

public class Test06 {

	public static int getNumber(String msg, Scanner sc) {
		String input = "";
		while(true) {
			System.out.print(msg);
			input = sc.nextLine();
			try {
				return Integer.parseInt(input);
			} catch(Exception e) {
				System.out.println("!!잘못된 값 기입");
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = getNumber("값 입력", sc);
		for(int i = 1; i < 11; i++) {
			System.out.printf("%d * %d = %d\n",num, i, num*i);
		}
	}

}
