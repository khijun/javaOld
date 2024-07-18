package p367;

import java.util.Scanner;

public class DriverEx {
	public static void main(String[] args) {
		int num = 0;
		System.out.print("차량을 선택하세요(1:버스, 2:택시)>");
		try(Scanner sc = new Scanner(System.in);){
			num = sc.nextInt();
		}catch(Exception e) {
			
		}
		Vehicle v1 = null;
		switch(num) {
			case 1:
				v1 = new Bus();
				break;
			case 2:
				v1 = new Taxi();
				break;
			default:
				break;
		}
		
		Driver driver = new Driver();
		driver.drive(v1);
	}
}
