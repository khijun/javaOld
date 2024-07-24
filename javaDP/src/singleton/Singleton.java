package singleton;

public class Singleton {
	private static Singleton sc = new Singleton();
	private Singleton() {
		System.out.println("싱글톤 객체 생성");
	}
	public static Singleton getInstance() {
		return sc;
	}
}
