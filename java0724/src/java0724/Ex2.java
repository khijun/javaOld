package java0724;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex2 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select deptno, dname, loc from dept where loc like ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩");
			con = DriverManager.getConnection(url, "root", "mysql");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "서울");
			ResultSet rs = pstmt.executeQuery();
//			System.out.println(result + "건 성공");
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.printf("%d, %s, %s\n", deptno, dname, loc);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

