package lambda;

public class Ex3 {
	public static void main(String[] args) {
		MyInterf2 my2 = (a)->{
			System.out.println(a + "");
		};
		
		my2.method(5);
		
		MyInterf2 my2_2 = a->System.out.println(a);
		my2_2.method(10);
	}
}
