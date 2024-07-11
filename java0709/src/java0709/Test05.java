package java0709;

import java.util.Scanner;

public class Test05 {
	
	public static int getNumber(String msg, Scanner sc) {
		String input = "";
		int inputScore = 0;
		while(true) {
			System.out.print(msg);
			input = sc.nextLine();
			try {
				inputScore = Integer.parseInt(input);
				if(inputScore  > 100 || inputScore  < 0)
					throw new Exception();
				return inputScore;
			} catch(Exception e) {
				System.out.println("!!잘못된 값 기입");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		char rank = ' ';
		score = getNumber("학점 입력: ",scanner);
		switch(score/10) {
		case 9:
			rank = 'A';
			break;
		case 8:
			rank = 'B';
			break;
		case 7:
			rank = 'C';
			break;
		case 6:
			rank = 'D';
			break;
		default:
			rank = 'F';
		}
		System.out.println(rank);
	}
}
