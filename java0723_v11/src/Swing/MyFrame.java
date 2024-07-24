package Swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{
	int selection = 0;
	String[][] paths = {{"stand.gif"}
	,{"walk1.gif", "walk2.gif"}
	,{"run1.gif","run2.gif", "run3.gif"}}; 
	private class Control extends JPanel{

		private JButton standingBtn, walkingBtn, runningBtn;
		public Control() {
			this.setLayout(new FlowLayout());
			
			standingBtn = new JButton("Standing");
			walkingBtn = new JButton("Walking");
			runningBtn = new JButton("Running");
			
			standingBtn.addActionListener(e->selection = 0);
			walkingBtn.addActionListener(e->selection = 1);
			runningBtn.addActionListener(e->selection = 2);
			this.add(standingBtn);
			this.add(walkingBtn);
			this.add(runningBtn);
		}
	}
	
	private class Field extends JPanel implements Runnable{
		JLabel lb1;
		Field(){
			this.setLayout(new BorderLayout());
			lb1 = new JLabel("Empty");
			this.add(lb1,BorderLayout.CENTER);
		}
		@Override
		public void run() {
			while(true) {
				for(String str : paths[selection]) {
					lb1.setIcon(new ImageIcon("C:/_dev/eclipse workspace/java0717/src/images/" + str));
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public MyFrame() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Field field = new Field();
		Control control = new Control();
		this.add(field, BorderLayout.CENTER);
		this.add(control, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setTitle("0723");
		this.setBounds(1000, 200,500, 600);
		new Thread(field).start();
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
