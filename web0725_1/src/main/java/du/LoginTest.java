package du;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginTest {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from account where name = ? and ssn = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "mysql");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "홍길동");
			pstmt.setString(2, "911224");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Account a = new Account(rs.getInt("id"), rs.getString("name"),rs.getString("ssn"),
						rs.getString("tel"),rs.getInt("balance"));
				String str = String.format("%d, %s, %s, %s, %d\n", a.getId(), a.getName(),
						a.getSsn(), a.getTel(), a.getBalance());
				System.out.println(str);
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
