package java0731;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Ex7_Optional {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		OptionalDouble avg = list.stream()
						.mapToInt(Integer::intValue)
						.average();
		
		System.out.println(avg);
		if(avg.isPresent()) {
			System.out.println(avg.getAsDouble());
		} else {
			System.out.println("값이 없음");
		}
		
		double avg1 = list.stream()
				.mapToInt(Integer::intValue)
				.average().orElse(0.0);
		
		System.out.println(avg1);
		
		list.stream().mapToInt(Integer::intValue)
			.average()
			.ifPresent(System.out::println);
	}
}
