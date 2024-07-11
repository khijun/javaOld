package java0709;

import java.util.Scanner;

public class Test02 {
	
	public static int getNumber(String msg, Scanner sc) {
		System.out.print(msg);
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}

	public static void main(String[] args) {
		int apple, people;
		Scanner scanner = new Scanner(System.in);
		apple = getNumber("사과의 개수 입력: ", scanner);
		people = getNumber("친구 명수 입력: ", scanner);
		System.out.printf("사과 %d개를 %d명에게 나누어 %d개가 남았습니다.", apple, ++people, apple%people);
	}

}
