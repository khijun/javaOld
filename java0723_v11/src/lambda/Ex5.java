package lambda;

public class Ex5 {
	public static void main(String[] args) {
		MyInterf4 my4 = (x,y)->{
			return x+y;
		};
		System.out.println(my4.method(500, 200));
		
		MyInterf5 my4_2 = x->x<<1;;
		
		System.out.println(my4_2.method(2));
	}
}
