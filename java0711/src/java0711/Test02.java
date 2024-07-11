package java0711;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		while(true) {
			System.out.println("값 입력>");
			try{
				x = Integer.parseInt(sc.nextLine());
				if(x<=0)
					throw new Exception();
				break;
			} catch(Exception e) {
				System.out.println("입력값 오류");
			}
		}
		int total = 0;
		for(int i = 1; i <= x; i++)
			total += i;
		
		System.out.println(total);
		sc.close();
	}
 
}
