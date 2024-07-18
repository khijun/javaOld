package p362_Tire;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		
		for(int i = 1; i <= 5; i++) {
			TireLoc problemLocation = car.run();
			
			if(problemLocation != null) {
				switch(problemLocation) {
				case frontLeftTire:
					System.out.println("앞왼쪽 타이어 HankookTire로 교체");
					car.frontLeftTire = new HankookTire(TireLoc.frontLeftTire, 15);
					break;
				case frontRightTire:
					System.out.println("앞오른쪽 타이어 KumhoTire로 교체");
					car.frontRightTire = new HankookTire(TireLoc.frontRightTire, 13);
					break;
				case backLeftTire:
					System.out.println("뒤왼쪽 타이어 HankookTire로 교체");
					car.backLeftTire = new HankookTire(TireLoc.backLeftTire, 14);
					break;
				case backRightTire:
					System.out.println("뒤오른쪽 타이어 KumhoTire로 교체");
					car.backRightTire = new HankookTire(TireLoc.backRightTire, 15);
					break;
				}
			}
			System.out.println("---------------------------");
		}
	}
}
