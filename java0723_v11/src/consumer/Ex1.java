package consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Ex1 {
	public static void main(String[] args) {
		Consumer<String> consumer = a->System.out.println(a);;
		consumer.accept("Hello Java");
		
		BiConsumer<String, String> consumer2 = (a,b)->{
			System.out.println(a + b);
		};
		consumer2.accept("Hello ", "Java");
	}
}
