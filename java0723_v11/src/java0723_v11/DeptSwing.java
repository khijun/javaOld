package java0723_v11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DeptSwing extends JFrame{
	
	JTextField tf = new JTextField(30);
	JTextField timeDisplayer = new JTextField(5);
	JTextArea ta = new JTextArea(10, 50);
	JButton jb1 = new JButton("출력");
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	String sql = null;
	
	DeptSwing(){
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel(new FlowLayout());
		JPanel jp2 = new JPanel(new FlowLayout());
		TimeDisplayer td = new TimeDisplayer();
		new Thread(td).start();
		jp1.add(tf);
		jp1.add(jb1);
		jp2.add(ta);
		con.add(jp1,BorderLayout.NORTH);
		con.add(jp2, BorderLayout.CENTER);
		con.add(td, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("안녕 스윙");
		this.setBounds(700, 300,600, 300);
		this.setVisible(true);
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속성공");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				try{
					String loc = tf.getText();
					sql = String.format("select * from dept where loc = '%s'", loc);
					System.out.println("dept 출력");
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
//					String result = "";
					if(!rs.next()) {
						JOptionPane.showMessageDialog(con, "123", "정보", JOptionPane.INFORMATION_MESSAGE);
					}else {
						do {
							ta.append(String.format("%d, %s, %s\n", rs.getInt(1), rs.getString(2), rs.getString(3)));
						}while(rs.next());
					}
				}catch(SQLException exc) {
					System.out.println("emp 출력 실패");
				}
			}
		});
		
	}
	
	class TimeDisplayer extends JPanel implements Runnable{
		@Override
		public void run() {
			while(true){
				LocalTime lc = LocalTime.now();
				int hour = lc.getHour(); 
				String h = hour>9?""+hour:"0"+hour;
				int minute = lc.getMinute();
				String m = minute>9?""+minute:"0"+minute;
				int second = lc.getSecond();
				String s = second>9?""+second:"0"+second;
				DeptSwing.this.timeDisplayer.setText(String.format("%s:%s:%s", h, m, s));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		TimeDisplayer(){
			this.add(timeDisplayer);
		}
		
	}
	
	public static void main(String[] args) {
		new DeptSwing();
	}

}
