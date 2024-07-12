package java0712;

import java.util.Scanner;

public class SearchEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a[] = {"Hello", "java", "abc", "du", "spring"};
		int find = -1;
		
		System.out.print("문자열 입력>");
		String var = sc.nextLine();
		
		for(int i = 0; i < a.length; i++) {
			if(a[i].equals(var)) {
				find = i;
				break;
			}
		}
		if(find == -1) {
			System.err.println("문자열을 찾지 못함");	//	??
		}else
			System.out.printf("%d번째에 존재", find+1);
		sc.close();
	}

}
