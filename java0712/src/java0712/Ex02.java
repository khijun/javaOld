package java0712;

import java.util.Random;

public class Ex02 {

	public static void main(String[] args) {
		Random rd = new Random();
		int[] count = new int[10];
		int random = 0;
		for(int i = 0; i < 100000; i++) {
			random = rd.nextInt(10)+1;
			count[random-1]++;
		}
		for(int i : count) {
			System.out.println(i);
		}
	}

}
