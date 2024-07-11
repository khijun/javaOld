package java0710;

public class Ex03 {
	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		
		do {
			if(i%2==0) {
				sum += i;
			}
			i++;
		} while(i <= 100);
		System.out.println(sum);
	}
}
