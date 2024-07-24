package thread;

public class Ex1 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Th1());
		thread.start();
		
		for(int i = 0; i < 5; i++) {
			System.out.print("띵");
			Thread.sleep(1000);
		}
	}
}
