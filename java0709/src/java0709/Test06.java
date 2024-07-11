package java0709;

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
		Scanner scanner = new Scanner(System.in);
		int x = getNumber("값 입력: ", scanner);
		if(x>=0) {
			System.out.print(x);
		} else {
			System.out.println(Math.abs(x));
		}
	}
}
