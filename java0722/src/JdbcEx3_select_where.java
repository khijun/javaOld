import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx3_select_where {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("접속성공");
			stmt = conn.createStatement();
			System.out.println("부서번호: ");
			int deptno = Integer.parseInt(sc.nextLine());
			System.out.println("부서명: ");
			String dname = sc.nextLine();
			System.out.println("부서위치: ");
			String loc = sc.nextLine();
			String sql = String.format("select * from dept where deptno = %d "
					+ "and dname='%s' and loc='%s'", deptno,dname,loc);
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				do {
					System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				}while(rs.next());
				System.out.println("쿼리 성공");
			} else {
				System.out.println(String.format("%d, %s, %s", deptno, dname,loc) + "에 일치하는 데이터 없음");
			}
			
		} catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
}
