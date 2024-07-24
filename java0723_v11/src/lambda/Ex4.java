package lambda;

public class Ex4 {
	public static void main(String[] args) {
		MyInterf3 my3 = (a,b)->{
			System.out.println(a+b);
		};
		
		my3.method(100, 300);
	}
}
