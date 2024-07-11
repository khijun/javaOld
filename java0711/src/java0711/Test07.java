package java0711;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = input.getNumber("2자리 양수 입력",sc,10,99);
		System.out.println(a);
	}

}
