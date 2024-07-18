package p347_protected_2;

import p347_protected.A;

public class C extends A{
	public void method2() {
		field = "val";
		this.method();
//		A a = new A();
	}
}
