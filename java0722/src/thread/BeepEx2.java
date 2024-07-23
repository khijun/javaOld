package thread;

public class BeepEx2 {
	public static void main(String[] args) {
		Thread th = new Thread(new BeepTask());
		th.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
