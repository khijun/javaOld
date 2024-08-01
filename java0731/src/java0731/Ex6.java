package java0731;

import java.util.Arrays;
import java.util.List;

public class Ex6 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("홍길동", "신용권", "김자바", "신용권", "신인철");
		
		names.stream()
			.distinct()
			.limit(2)
			.forEach(System.out::println);
		
		names.stream()
			.filter(n-> n.startsWith(n))
			.forEach(System.out::println);
		
		names.stream()
			.distinct()
			.filter(new String()::startsWith)
			.forEach(System.out::println);
	}
}
