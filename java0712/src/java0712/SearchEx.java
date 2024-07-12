package java0712;

public class SearchEx {

	public static void main(String[] args) {
		int a[] = {10, 3, 1, 4, 2};
		int var = 4;
		int find = -1;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] == var) {
				find = i;
				break;
			}
		}
		if(find != -1) {
			System.out.printf("%d번째에 존재", find);
		}
	}

}
