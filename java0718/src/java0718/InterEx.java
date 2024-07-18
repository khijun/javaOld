package java0718;

public class InterEx {
	public static void main(String[] args) {
		ImplC implC = new ImplC();
		
		InterA ia = implC;
		ia.methodA();
		System.out.println();
		
		InterB ib = implC;
		ib.methodB();
		System.out.println();
		
		InterC ic = implC;
		ic.methodA();
		ic.methodB();
		ic.methodC();
		System.out.println();
		
		implC.methodA();
		implC.methodB();
		implC.methodC();
	}
}
