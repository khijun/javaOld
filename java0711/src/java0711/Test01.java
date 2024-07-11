package java0711;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = getNumber("첫 번째 정수 입력>", sc);
		int x2 = getNumber("두 번째 정수 입력>", sc);
		int x3 = getNumber("세 번째 정수 입력>", sc);
		
		int center = (x1>=x2&&x3>=x1||x1>=x3&&x1>=x2)?x1:
			(x2>=x1&&x3>=x2||x2>=x3&&x2>=x1)?x2:x3;
		System.out.println(center);
		System.out.println(getCenter(54,32,21,43,10));
		
	}

	public static int getNumber(String msg, Scanner sc) {
		System.out.println(msg);
		String input = sc.nextLine();
		int x = Integer.parseInt(input);
		return x;
	}
	
	public static int getCenter(int...args) {	
		System.out.println();
		boolean flag = true;
		int temp = args[0];
		int[] list = new int[args.length];
		for(int i = 0; i < args.length; i++) {
			list[i] = args[i];
		}
		while(flag){
			flag = false;
			for(int i = 1; i < args.length; i++) {
				if(list[i-1] > list[i]) {
					temp = list[i-1];
					list[i-1] = list[i];
					list[i] = temp;
					flag = true;
				}
			}
		}
		for(int i : list)
			System.out.println(i);
		System.out.println("");
		return list[(list.length/2)];	//	중복대처 필요
	}
}
