package lambda;

public class Ex1 {
	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
				for(int i = 0; i < 5; i++) {
					System.out.print("삐");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}).start();
		
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for(int i = 0; i < 5; i++) {
//					System.out.print("삐");
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
		
		for(int i = 0; i < 5; i++) {
			System.out.print("띵");
			Thread.sleep(500);
		}
	}
}
