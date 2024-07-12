package java0712;

public class Ex03 {

	public static void main(String[] args) {
		int[][] array = {{1,1},{1,1,1},{1,1,1,1}};
		System.out.println(array[0].length);
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("%d\t", array[i][j]);
			}
		}
	}

}
