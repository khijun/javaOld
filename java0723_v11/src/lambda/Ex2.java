package lambda;

public class Ex2 {
	public static void main(String[] args) {
		MyInterf1 my = ()->{
			System.out.println("method()");
		};
		
		my.method();
	}
}
