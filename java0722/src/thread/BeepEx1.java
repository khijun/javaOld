package thread;

import java.awt.Toolkit;

public class BeepEx1 {
	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		for(int i=0;i<5;i++) {
			tk.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
