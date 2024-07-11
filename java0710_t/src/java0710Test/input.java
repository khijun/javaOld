package java0710Test;

import java.util.Scanner;

public class input {
	
	final static int MIN = 0;
	final static int MAX = 100000000;

	public static int getNumber(String msg, Scanner sc, int min, int max) {
		int number = 0;
		while(true) {
			try {
				System.out.println(msg);
				number = Integer.parseInt(sc.nextLine());
				if(number > max)
					throw new Exception();
				if(min > number)
					throw new Exception();
				return number;
			}catch(Exception e) {
				System.out.println("숫자가 범위를 벗어났거나 잘못됐습니다.");
			}
		}
	}
	
	public static int getNumber(String msg, Scanner sc) {
		return getNumber(msg,sc, MIN, MAX);
	}
	
	public static int getNumber(String msg, Scanner sc, int min) {
		return getNumber(msg,sc, min, MAX);
	}
	
	public static String getString(String msg, Scanner sc) {
		System.out.println(msg);
		String str = sc.nextLine();
		return str;
	}
	
}
