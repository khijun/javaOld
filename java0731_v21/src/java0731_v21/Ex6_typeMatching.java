package java0731_v21;

public class Ex6_typeMatching {
	public static void method(Object o) {
		switch(o) {
		case Integer i -> System.out.println(i);
		case null, default -> System.out.println("null");
		}
	}
	
	public static void main(String[] args) {
		int i = 10;
		method(10);
		method('c');
	}
}
