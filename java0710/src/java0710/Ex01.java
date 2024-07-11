package java0710;

public class Ex01 {
	public static void main(String[] args) {
		String s1 = String.valueOf(Integer.parseInt("100") + 3);
		System.out.println(s1);
		System.out.println(s1.getClass());
		
		String s2 = 3 + "100";
		System.out.println(s2);
		
		int x1 = 1;
		int x2 = 3;
		int x3 = x1 / x2;
		System.out.println(x3);
		
		double result3 = (double)x1 / x2;
		System.out.println(result3);
		
		//float result = 1.5f + 3.4f;
		//double result2 = 1.5 + 3.4;
		
		byte a1 = 10;
		byte b2 = 20;
		//byte c3 = (byte)(a1 + b2);
		
		int r1 = a1 + b2;
		System.out.println(r1);
		
		int b1 = -65471;
		char c1 = (char) b1;
		System.out.println(c1);
		
		int x = 200;
		byte y = (byte) x;
		System.out.println(y);
		
		double d1 = 3.14;
		int z = (int) d1;
		System.out.println(z);
	}
}
