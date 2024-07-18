package swing;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame {
	public static void main(String[] args) {
		new MouseListenerEx();
	}
}

class MouseListenerEx extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel jp = new JPanel();
	JLabel la = new JLabel("No Mouse Event");
	
	MouseListenerEx(){
		this.setContentPane(jp);
		jp.add(la);
		this.setSize(700, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp.addMouseListener(new MyMouseListener());
		jp.addMouseMotionListener(new MyMouseListener());
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener{

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			la.setText("Click(" + e.getX() + ", " + e.getY() +")");
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			la.setText("Press(" + e.getX() + ", " + e.getY() +")");
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			la.setText("Release(" + e.getX() + ", " + e.getY() +")");
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			jp.setBackground(Color.CYAN);
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			jp.setBackground(Color.GREEN);
		}

		@Override
		public void mouseDragged(java.awt.event.MouseEvent e) {
			la.setText("Drag(" + e.getX() + ", " + e.getY() +")");
			
		}

		@Override
		public void mouseMoved(java.awt.event.MouseEvent e) {
			la.setText("Move(" + e.getX() + ", " + e.getY() +")");
			
		}
		
	}
}