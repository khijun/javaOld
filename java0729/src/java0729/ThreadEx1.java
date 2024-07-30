package java0729;

public class ThreadEx1 {
	public static void main(String[] args) {
		Thread mThread = Thread.currentThread();
		System.out.println(mThread.getName());
		
		ThreadA threadA = new ThreadA();
		threadA.start();
		
		Thread b = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 2; i++) {
					System.out.println(getName());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		};
		b.setName("ThreadB");
		b.start();
		
		Thread c = new Thread(new Runnable() {
			@Override
			public void run() {
//				System.out.println(this.getName());
			}
			
		});
	}
}
