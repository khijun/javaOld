package board;


public class SelectSort {
	public static void main(String[] args) {
		int[] arr = new int[100];
		for(int c=0;c<arr.length;c++) {
			arr[c] = arr.length-c;
		}
		System.out.println("start");
//		for(int i=0; i<arr.length;i++) {
//			for(int j=i+1;j<arr.length;j++) {
//				if(arr[i]>arr[j]) {
//					int temp = arr[j];
//					arr[j] = arr[i];
//					arr[i] = temp;
//				}
//			}
//		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int s : arr) {
			System.out.print(s+",");
		}
	}
}
