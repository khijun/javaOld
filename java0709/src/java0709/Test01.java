package java0709;

public class Test01 {
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		printXY(x,y);
		swap(x,y);
	}
	public static void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
		System.out.printf("%d, %d\n", x, y);
	}
	public static void printXY(int x, int y) {
		System.out.printf("%d, %d\n", x, y);
	}
}
