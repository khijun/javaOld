package java0712;

public class BubbleEx {
	
	public static void printSortedArray(int[] a) {
		int temp = 0;
		for(int i = 0; i < a.length-1; i++) {
			for(int j = a.length-1; j > i; j--) {
				if(a[j] < a[j-1]) {
					temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		for(int i = 0; i < a.length; i++) {
			if((i)%10 == 0)
				System.out.println();
			System.out.printf("%d \t",a[i]);
		}
	}

	public static void main(String[] args) {
		int a[] = {10, 3, 1, 4, 2};
		printSortedArray(a);
		
		int list[] = new int[100];
		for(int i = 0; i < list.length; i++) {
			list[i] = (int)(Math.random()*100+1);
		}
		printSortedArray(list);
		

	}

}
