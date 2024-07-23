import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx3_insert {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		String sql = "insert into dept values("
				+ "101, '영업부', '서울')";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("접속성공");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("쿼리 성공");
			
		} catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
}
