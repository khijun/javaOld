package java0710;

public class Test05 {

	public static void main(String[] args) {
		for(int i = 1; i < 11; i++) {
			for(int j = 2; j < 11; j++) {
				System.out.printf("%d x %d = %d\t", j, i, i*j);
			}
			System.out.println();
		}
	}

}
