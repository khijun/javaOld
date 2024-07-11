package java0711;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("값 잆력");
		int a = Integer.parseInt(sc.nextLine());
		System.out.println("값 잆력");
		int b = Integer.parseInt(sc.nextLine());
		
		if(a==b) {
			System.out.println("a==b");
			sc.close();
			return;
		}
		System.out.println(getSum(a,b));
		sc.close();
	}

	public static int getSum(int a, int b) {
		int result = 0;
		int max = a>b?a:b;
		
		for(int i = a>b?b:a;i <= max;i++) {
			result += i;
		}
		
		return result;
	}
}
