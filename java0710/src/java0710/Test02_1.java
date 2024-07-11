package java0710;

public class Test02_1 {

	public static void main(String[] args) {
		float sum = 0;
		for (float i = 0.1f; i < 1.1f; i+= 0.1f) {
			System.out.println(Float.toString(i));
			sum += i;
		}
		System.out.println(sum);
	}

}
