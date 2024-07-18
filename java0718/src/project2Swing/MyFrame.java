package project2Swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("unchecked")
public class MyFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	ArrayList<Member> list;
	Member member;
	JLabel lb1 = new JLabel("아이디");
	JTextField jt1 = new JTextField(10);
	JLabel lb2 = new JLabel("SSN");
	JTextField jt2 = new JTextField(10);
	JLabel lb3 = new JLabel("전화번호");
	JTextField jt3 = new JTextField(10);
	JButton jb1 = new JButton("로그인");
	JButton jb2 = new JButton("회원가입");
	JButton jb3 = new JButton("예금");
	JButton jb4 = new JButton("출금");
	JButton jb5 = new JButton("잔고");
	JTextArea ta = new JTextArea(20,70);

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
		con.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel(new FlowLayout());
		JPanel jp2 = new JPanel(new FlowLayout());
		JPanel jp3 = new JPanel(new FlowLayout());
		
		jp1.add(lb1);
		jp1.add(jt1);
		jp1.add(lb2);
		jp1.add(jt2);
		jp1.add(lb3);
		jp1.add(jt3);
		con.add(jp1,BorderLayout.NORTH);
		jp2.add(ta);
		con.add(jp2,BorderLayout.CENTER);
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);
		jp3.add(jb4);
		jp3.add(jb5);
		con.add(jp3,BorderLayout.SOUTH);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
						
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("안녕 스윙");
		this.setLocation(700, 300);
		this.setSize(900, 500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			if(member != null) {
				member = null;
				ta.setText("로그아웃 완료");
				jb1.setText("로그인");
			}else {
			String name = jt1.getText();
			String ssn = jt2.getText();
			for(Member m : list) {
				if(name.equals(m.getName())&&ssn.equals(m.getSsn())) {
					member = m;
					ta.setText("현재 유저: " + member.getName());
					jt1.setText("");
					jt2.setText("");
					jb1.setText("로그아웃");
					break;
				}
			}
			if(member == null)
				ta.setText("로그인 실패");
				jt2.setText("");
			}
		}else if(e.getSource() == jb2) {
			String name = jt1.getText();
			String ssn = jt2.getText();
			String phone = jt3.getText();
			if(name.equals("")||ssn.equals("")||phone.equals("")) {
				ta.setText("필수 항목 입력 요망");
			}else {
				list.add(new Member(name, ssn, phone));
				ta.setText("회원가입 완료");
			}
		}else if(e.getSource() == jb3) {
			if(member == null) {
				ta.setText("로그인 필요");
			}else {
				int value = Integer.parseInt(jt3.getText());
				member.deposit(value);	// 임시로 전화번호 칸에 기입
				ta.setText("예금한 금액: "+ value);
			}
		}else if(e.getSource() == jb4) {
			if(member == null) {
				ta.setText("로그인 필요");
			}else {
				int value = Integer.parseInt(jt3.getText());
				if(member.withdraw(value)) {	// 임시로 전화번호 칸에 기입
					ta.setText("출금한 금액: "+ value);
				}else {
					ta.setText("출금 실패");
				}
			}
		}else if(e.getSource() == jb5) {
			if(member == null) {
				ta.setText("로그인 필요");
			}else {
				ta.setText("현재 잔고: "+ member.getBalance());
			}
		}else {
			
		}
		
	}
	
}
