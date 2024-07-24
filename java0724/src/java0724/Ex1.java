package java0724;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex1 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update dept set dname = ?, loc = ? where deptno = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩");
			con = DriverManager.getConnection(url, "root", "mysql");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "테스트부");
			pstmt.setString(2, "강릉");
			pstmt.setInt(3, 1006);
			int result = pstmt.executeUpdate();
			System.out.println(result + "건 성공");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
