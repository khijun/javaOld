package deptSwing;

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
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DeptSwing extends JFrame{
	
	JTextField tf = new JTextField(50);
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
		JPanel jp3 = new JPanel(new FlowLayout());
		jp1.add(ta);
		jp1.add(tf);
		jp1.add(jb1);
		con.add(jp1);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("안녕 스윙");
		this.setLocation(700, 300);
		this.setSize(900, 500);
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
//						ta.setText(loc + "에 맞는데이터가 없음");
						JOptionPane.showMessageDialog(con, "123", "정보", JOptionPane.INFORMATION_MESSAGE);
					}else {
						do {
	//						result += String.format("%d, %s, %s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
							ta.append(String.format("%d, %s, %s\n", rs.getInt(1), rs.getString(2), rs.getString(3)));
						}while(rs.next());
					}
//					ta.setText(result);
				}catch(SQLException exc) {
					System.out.println("emp 출력 실패");
				}
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		new DeptSwing();
	}

}
