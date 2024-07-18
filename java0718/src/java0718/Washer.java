package java0718;

public class Washer extends HomeApliancies{
	Washer(){
		super();
	}

	@Override
	public void turnOn() {
		System.out.println("전원이 켜집니다");
	}

	@Override
	public void turnOff() {
		System.out.println("전원이 꺼집니다");
	}
}
