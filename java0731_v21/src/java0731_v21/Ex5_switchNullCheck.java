package java0731_v21;

public class Ex5_switchNullCheck {
	public static void main(String[] args) {
		String grade = null;
		switch(grade) {
			case "A", "a" -> {
				System.out.println("우수 회원");
			}
			case "B", "b" -> {
				System.out.println("일반 회원");
			}
			case null -> System.out.println("null");
			default -> {
				System.out.println("손님");
			}
		}
	}
}
