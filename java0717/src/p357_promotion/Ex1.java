package p357_promotion;

class A{
	
}

class B extends A{
	int x;
}

public class Ex1 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		A b = new B();
//		b.x = 1;
	}
}
