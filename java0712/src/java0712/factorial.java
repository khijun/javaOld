package java0712;

public class factorial {
	public static void main(String[] args) {
		int num = 5;
		int result = fac(num);
		System.out.printf("%d! = %d", num, result);
	}
	public static int fac(int num) {
		if(num == 0) 
			return 1;
		return num * fac(num - 1);
	}
}
