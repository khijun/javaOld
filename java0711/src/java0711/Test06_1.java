package java0711;

import java.util.Scanner;

public class Test06_1 {

	public static void main(String[] args) {
		int n, w;
		Scanner sc = new Scanner(System.in);
		n = input.getNumber("첫 번째 값 입력>", sc,0);
		w = input.getNumber("두 번째 값 입력>", sc,1,n);
		System.out.printf("%d개의 *을 출력, %d개마다 줄바꿈\n",n,w);
		for(int i = 0; i<n; i++) {
			if(i%w==0)
				System.out.println();
			System.out.print('*');
		}
	}

}
