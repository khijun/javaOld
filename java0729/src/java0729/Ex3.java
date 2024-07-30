package java0729;

public class Ex3 {
	public static void main(String[] args) {
		int x = 100;
		Integer y;
		y = 100;
		
		x = Integer.parseInt("400");
		y = Integer.valueOf("400");
		
		String str = "이것은 자바 대치 예제입니다. ";
		String newStr = str.replace("예제", "코드");
		str  = str.replace("예제", "코드");
		System.out.println(str);
		System.out.println(newStr);
		if(str==newStr) {
			System.out.println("같은 저장소");
		}else {
			System.out.println("다른 저장소");
		}
			
	}
}
