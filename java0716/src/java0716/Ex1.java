package java0716;

public class Ex1 {
	public static void main(String[] args) {
		Cat cat = new Cat("페르시안", "검정", 10);
		Calculator c = new Calculator();
		System.out.println(cat);
		System.out.println(c.avg(1,2));
	}
}
