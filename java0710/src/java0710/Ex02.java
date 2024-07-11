package java0710;

public class Ex02 {
	public static void main(String[] args) {
		String str1 = "가나다";
		String str2 = "가나다";
		boolean result1 = str1 == str2;
		System.out.println(result1);
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		String str3 = new String("가나다");
		String str4 = new String("가나다");
		boolean result2 = str3.equals(str4);
		System.out.println(result2);
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
	}
}
