package java0711;

public class Ex02 {

	public static void main(String[] args) {
		int scores[] = new int[] {83,90,87};
		int scores2[] = {83,90,87};
		int total = 0;
		
		for(int i = 0; i < scores.length; i++) {
			total += scores[i];
		}
		System.out.println(total);
		System.out.println((double)total/scores.length);
		
		for(int i : scores2) {
			System.out.println(i);
		}
		System.out.println();
		
		int[] myArr = new int[5];
		for(int i=0;i<myArr.length;i++) {
			System.out.println(myArr[i]);
		}
		double[] myArr2 = new double[5];
		for(int i=0;i<myArr2.length;i++) {
			System.out.println(myArr2[i]);
		}
		boolean[] myArr3 = new boolean[5];
		for(int i=0;i<myArr3.length;i++) {
			System.out.println(myArr3[i]);
		}
	}

}
