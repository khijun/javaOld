package java0712;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("생성할 배열 길이 입력>");
		int arrLength = Integer.parseInt(sc.nextLine());
		int arr[] = new int[arrLength];
		System.out.println(arr.length);
		for(int i = 0; i < arrLength; i++) {
			System.out.print(i+1 + "번째 값 입력>");
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		for(int i : arr) {
			System.out.print("i값: " + i + " ");
		}
		
		sc.close();
	}

}
