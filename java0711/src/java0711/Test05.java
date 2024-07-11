package java0711;

public class Test05 {

	public static void main(String[] args) {
		String str = "";
		for(int i = 0; i<=12; i++) {
			str = i%2==0?"+":"-";
			System.out.print(str);
		}
	}

}
