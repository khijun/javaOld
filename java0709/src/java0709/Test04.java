package java0709;

import java.util.Scanner;

public class Test04 {
	
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
	
	public static int getMax(int x, int y, int z) {
		int max = x;
		if(y > max) {
			max = y;
		}
		if(z > max) {
			max = z;
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a = getNumber("첫 번째 수 입력: ", scanner);
		int b = getNumber("두 번째 수 입력: ", scanner);
		int c = getNumber("세 번째 수 입력: ", scanner);

		System.out.println(getMax(a,b,c));
	}
}
