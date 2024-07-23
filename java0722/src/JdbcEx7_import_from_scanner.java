import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx7_import_from_scanner {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try(Scanner sc = new Scanner(System.in)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("접속성공");
			stmt = conn.createStatement();
			System.out.println("부서 이름 입력");
			String dname = sc.nextLine();
			System.out.println("부서 위치 입력");
			String loc = sc.nextLine();
			
			String sql = "select max(deptno) from dept";
			rs = stmt.executeQuery(sql);
			rs.next();
			int deptno = rs.getInt(1);
			
			sql = String.format("insert into dept value(%d, '%s', '%s')", deptno + 1, dname, loc);
			
			stmt.executeUpdate(sql);
			
			System.out.println("쿼리 성공");
			
		} catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
}
