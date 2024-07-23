package java0723_v11;

public class A {
	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {};
	
	public static void main(String[] args) {
		System.out.println(A.field2);
		A a = new A();
		System.out.println(a.field1);
	}
}
