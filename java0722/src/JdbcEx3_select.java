import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx3_select {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from dept";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("접속성공");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
			}
			System.out.println("쿼리 성공");
			
		} catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
}
