package java0723_v11;

import java.time.LocalTime;

public class DisplayDateTime {
	public static void main(String[] args) throws InterruptedException {
		new Thread() {
			@Override
			public void run() {
				while(true) {
					LocalTime lc = LocalTime.now();
					int hour = lc.getHour(); 
					String h = hour>9?""+hour:"0"+hour;
					int minute = lc.getMinute();
					String m = minute>9?""+minute:"0"+minute;
					int second = lc.getSecond();
					String s = second>9?""+second:"0"+second;
					System.out.printf("%s:%s:%s", h, m, s);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		}}.start();
		
		while(true) {
			System.out.println("띵");
			Thread.sleep(1000);
		}
	}
}
