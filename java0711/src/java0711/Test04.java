package java0711;

import java.util.Scanner;

public class Test04 {

	
	public static int getNumber(String msg, Scanner sc) {
		System.out.println(msg);
		int number = 0;
		try {
			number = Integer.parseInt(sc.nextLine());
		}catch(Exception e) {
			System.out.println("숫자가 범위를 벗어났거나 잘못됐습니다.");
		}
		return number;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = getNumber("1부터 n까지의 합을 구할 n값 입력>", sc);
		int total = 0;
		for(int i = 1; i <= a; i++) {
			if(i < a)
				System.out.printf("%d+", i);
			else
				System.out.printf("%d=", i);
			total += i;
		}
		System.out.print(total);
	}

}
