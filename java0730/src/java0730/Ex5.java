package java0730;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Ex5 {
	public class MyClass{
		public void pow(Integer x) {
			System.out.println(x);
		}
	}
	
	public static void main(String[] args) {
		int count = 7;
//		IntStream ii = IntStream.range(1, 5);
		IntStream ii = IntStream.rangeClosed(1, count);
		int sum = IntStream.rangeClosed(1, count).sum();
		Integer[] sum1 = {1,2,3,4,5,6,7,8,9};
		List<Integer> list = Arrays.asList(sum1);
		list.stream().forEach(t -> System.out.println(t));
		MyClass mc = new Ex5().new MyClass();
		Consumer<Integer> c = mc::pow;
		c.accept(count);
	}
}
