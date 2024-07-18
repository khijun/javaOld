package p362_Tire;

public class Car {
	Tire frontLeftTire = new Tire(TireLoc.frontLeftTire, 6);
	Tire frontRightTire = new Tire(TireLoc.frontRightTire, 2);
	Tire backLeftTire = new Tire(TireLoc.backLeftTire , 3);
	Tire backRightTire = new Tire(TireLoc.backRightTire, 4);
	
	TireLoc run() {
		System.out.println("자동차가 달립니다");
		if(frontLeftTire.roll() == false) {stop(); return TireLoc.frontLeftTire;}
		if(frontRightTire.roll() == false) {stop(); return TireLoc.frontRightTire;}
		if(backLeftTire.roll() == false) {stop(); return TireLoc.backLeftTire;}
		if(backRightTire.roll() == false) {stop(); return TireLoc.backRightTire;}
		return null;
	}
	
	void stop() {
		System.out.println("자동차가 멈춥니다.");
	}
}
