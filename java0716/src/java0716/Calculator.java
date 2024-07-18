package java0716;


public class Calculator{
	public int plus(int x, int y) {
		return x+y;
	}
	
	double avg(int x, int y) {
		return plus(x,y) / 2d;
	}
	
	void execute() {
		double result = avg(7,10);
		println("실행 결과: " + result);
	}
	
	void println(String message) {
		System.out.println(message);
	}
}
