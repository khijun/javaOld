package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cal extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JLabel la1 = new JLabel("계산기");
	JLabel la2 = new JLabel("계산결과:");
	JTextField tf1 = new JTextField(10);
	JTextField tf2 = new JTextField(10);
	JButton jb1 = new JButton("+");
	JButton jb2 = new JButton("-");
	JButton jb3 = new JButton("*");
	JButton jb4 = new JButton("/");
	
	Cal(){
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		Container con= this.getContentPane();
		con.setLayout(new BorderLayout());
		jp1.add(la1);
		jp2.setLayout(new GridLayout(3,2,20,20));
		jp2.add(tf1);
		jp2.add(tf2);
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp3.add(la2);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		con.add(jp1,BorderLayout.NORTH);
		con.add(jp2, BorderLayout.CENTER);
		con.add(jp3, BorderLayout.SOUTH);
		this.setSize(700, 500);
		this.setLocation(1000,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Cal();
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == jb1) {
			la2.setText("계산결과:"+ (Integer.parseInt(tf1.getText()) + Integer.parseInt(tf2.getText())));
		}else if(e.getSource() == jb2) {
			la2.setText("계산결과:"+ (Integer.parseInt(tf1.getText()) - Integer.parseInt(tf2.getText())));
		}else if(e.getSource() == jb3) {
			la2.setText("계산결과:"+ (Integer.parseInt(tf1.getText()) * Integer.parseInt(tf2.getText())));
		}else if(e.getSource() == jb4) {
			la2.setText("계산결과:"+ (Integer.parseInt(tf1.getText()) / Integer.parseInt(tf2.getText())));
		}
	}
}


