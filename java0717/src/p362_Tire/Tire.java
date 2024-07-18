package p362_Tire;

public class Tire {
	public int maxRotation;
	public int accumulatedRotation;
	public TireLoc location;
	
	public Tire(TireLoc location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location + " Tire 수명: "+
			(maxRotation - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("***" + location + " Tire 펑크 ***");
			return false;
		}
	}
}
