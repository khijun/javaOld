package java0711;

public class Max {

	public static void main(String[] args) {
		 int a[] = {1,3,10,2,8};
		 
		 int max = 0;
		 for(int i = 1; i < a.length; i++) {
			 max = max>a[i]?max:a[i];
		 }
		 System.out.println(max);
	}

}
