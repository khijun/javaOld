package java0712;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoEx {

	public static void main(String[] args) {
		Random rd = new Random();
		int[] lotto = new int[6];
		int number = 0; 		
		for(int i = 0; i < lotto.length; i++) {
			number = rd.nextInt(100)+1;
			for(int j = 0; j < lotto.length; j++) {
				if(lotto[j] == number) {
					i -= 1;
					continue;
				}
			}
			lotto[i] = number;
			System.out.println(number);
		}
		
		Set<Integer> lottoSet = new HashSet<>();
		lottoSet.add(14);
		lottoSet.add(14);
		System.out.println(lottoSet.size());
	}

}
