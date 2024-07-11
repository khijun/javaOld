package java0710;

import java.util.Scanner;

@SuppressWarnings("resource")
public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(;;) {
			System.out.print("명령>>");
			String input = sc.nextLine();
			if(input.equalsIgnoreCase("q")){
				break;
			}
		}
		sc.close();
		System.out.println("종료!");
	}
}
