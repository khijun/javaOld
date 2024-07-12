package java0712;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수 입력>");
		int num = Integer.parseInt(sc.nextLine());
		double score[][] = new double[num][3];
//		0은 국어, 1은 수학, 2는 평균
		
		for(int i = 0; i < score.length; i++) {
			System.out.printf("[%d번째 학생]\n", i+1);
			System.out.print("국어 점수 입력>");
			score[i][0] = Double.parseDouble(sc.nextLine());
			System.out.print("수학 점수 입력>");
			score[i][1] = Double.parseDouble(sc.nextLine());
			score[i][2] = (double)(score[i][0] + score[i][1]) / 2;
		}
		System.out.printf("\t국어\t수학\t평균\n");
		System.out.println("============================");
		for(int i = 0; i < score.length; i++) {
				System.out.printf(
						"%d번 학생\t"
						+ "%3.2f\t"
						+ "%.2f\t"
						+ "%.2f\n",
						i+1,score[i][0],score[i][1],score[i][2]);
		}
		
		sc.close();
	}

}
