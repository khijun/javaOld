package java0729;

public class PrintThread2 extends Thread{
	
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
	@Override
	public void run() {
		while(true) {
			System.out.println("실행 중");
			if(Thread.interrupted())
				break;
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}
