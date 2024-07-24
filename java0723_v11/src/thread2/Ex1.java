package thread2;

public class Ex1 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Th1();
		thread.start();
		
		new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 5; i++) {
					System.out.print("E");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 5; i++) {
					System.out.print("띵");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}).start();
		
		for(int i = 0; i < 5; i++) {
			System.out.print("둥");
			Thread.sleep(500);
		}
	}
}
