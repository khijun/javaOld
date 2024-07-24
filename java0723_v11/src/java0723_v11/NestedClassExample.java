package java0723_v11;

public class NestedClassExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Car myCar = new Car();
		
		Car.Tire tire = myCar.new Tire();
		
		Car.Engine engine = new Car.Engine();
	}
}
