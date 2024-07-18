package project2Swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("unchecked")
public class MyFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	ArrayList<Member> list;
	Member member;
	JLabel lb1 = new JLabel("아이디");
	JTextField jt1 = new JTextField();
	JLabel lb2 = new JLabel("SSN");
	JTextField jt2 = new JTextField();
	JLabel lb3 = new JLabel("전화번호");
	JTextField jt3 = new JTextField();
	JButton jb1 = new JButton("로그인");
	JButton jb2 = new JButton("회원가입");
	JButton jb3 = new JButton("예금");
	JButton jb4 = new JButton("출금");
	JButton jb5 = new JButton("잔고");
	JTextArea ta = new JTextArea();

	public MyFrame() {		
		try(FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			list = (ArrayList<Member>) ois.readObject();

			System.out.println("파일 불러오기 성공");
		} catch(FileNotFoundException e) {
			System.err.println("파일을 찾지 못함!!");
			list.add(new Member("test","",""));
		} catch(IOException | ClassNotFoundException|ClassCastException e) {
			e.printStackTrace();
		}
		
		for(Member m : list) {
			System.out.println(m.toString());
		}
	
		Container con = this.getContentPane();
		con.setLayout(null);
		
		con.add(lb1);
		lb1.setLocation(20, 50);
		lb1.setSize(100, 30);
		
		con.add(jt1);
		jt1.setLocation(80, 50);
		jt1.setSize(100, 30);
		
		con.add(lb2);
		lb2.setLocation(220, 50);
		lb2.setSize(100, 30);
		
		con.add(jt2);
		jt2.setLocation(280, 50);
		jt2.setSize(100, 30);
		
		con.add(lb3);
		lb3.setLocation(420, 50);
		lb3.setSize(100, 30);
		
		con.add(jt3);
		jt3.setLocation(480, 50);
		jt3.setSize(100, 30);
		
		con.add(ta);
		ta.setLocation(20,120);
		ta.setSize(830, 200);
		
		con.add(jb1);	// 로그인
		jb1.setLocation(50, 350);
		jb1.setSize(100, 30);
		jb1.addActionListener(new jb1ClickListener());
		
		con.add(jb2);	// 회원가입
		jb2.setLocation(150, 350);
		jb2.setSize(100, 30);
		
		con.add(jb3);	// 예금
		jb3.setLocation(250, 350);
		jb3.setSize(100, 30);
		
		con.add(jb4);	// 출금
		jb4.setLocation(350, 350);
		jb4.setSize(100, 30);
		
		con.add(jb5);	// 잔고
		jb5.setLocation(450, 350);
		jb5.setSize(100, 30);
		jb5.addActionListener(new jb5ClickListener());
						
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("안녕 스윙");
		this.setLocation(700, 300);
		this.setSize(900, 500);
		this.setVisible(true);
		
		
	}
	
	class jb1ClickListener implements ActionListener{	// 로그인

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = jt1.getText();
			String strPassword = jt2.getText();//패스워드입력
			for(int i = 0; i < list.size(); i++) {
				if (name.equals(list.get(i).getName())) {
					if (strPassword.equals(list.get(i).getSsn())) {
						member = list.get(i);
						System.out.println("로그인 성공");
						break;	// 반복문 탈출
					}
				}
			}
		}
	}
	
	class jb2ClickListener implements ActionListener{	// 회원가입
		@Override
		public void actionPerformed(ActionEvent e) {
					
		}
	}
	class jb3ClickListener implements ActionListener{	// 예금
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	class jb4ClickListener implements ActionListener{	// 출금
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	class jb5ClickListener implements ActionListener{	// 잔고
		@Override
		public void actionPerformed(ActionEvent e) {
			ta.setText(String.valueOf(member.getBalance()));
		}
	}
	public static void main(String[] args) {
		new MyFrame();
		
	}
	
}
