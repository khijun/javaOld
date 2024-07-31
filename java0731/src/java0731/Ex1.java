package java0731;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ex1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		IntStream.rangeClosed(1, 5).forEach(list::add);
		System.out.println(list);
	}
}
