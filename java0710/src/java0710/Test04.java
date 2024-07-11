package java0710;

public class Test04 {

	public static void main(String[] args) {
		int total = 0;
		for(int i = 1; i<101; i++) {
			if(i%2 == 0)
				total += i;
		}
		System.out.println(total);
	}

}
