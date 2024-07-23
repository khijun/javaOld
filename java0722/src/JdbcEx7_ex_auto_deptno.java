import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx7_ex_auto_deptno {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		
		try(Scanner sc = new Scanner(System.in)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("접속성공");
			stmt = conn.createStatement();
			System.out.println("부서 번호 입력");
			int deptno = Integer.parseInt(sc.nextLine());
			System.out.println("부서 이름 입력");
			String dname = sc.nextLine();
			System.out.println("부서 위치 입력");
			String loc = sc.nextLine();
			
			String sql = String.format("insert into dept value(%d, '%s', '%s')", deptno, dname, loc);
			
			stmt.executeUpdate(sql);
			
			System.out.println("쿼리 성공");
			
		} catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
}
