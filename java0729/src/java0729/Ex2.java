package java0729;

public class Ex2 {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(time);
		
		for(int i = 0; i < 1000000; i++) {
			
		}
		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time);
	}
}
