package java0709;

import java.util.Scanner;

public class Test03 {
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
		Scanner scanner = new Scanner(System.in);
		int a = getNumber("첫 번째 값을 입력: ", scanner);
		int b = getNumber("두 번째 값을 입력: ", scanner);
		int result = -1;
		if(a>b) {
			result = a;
		} else if (b>a) {
			result = b;
		} else {
			result = 0;
		}
		System.out.println(result);
	}
}
