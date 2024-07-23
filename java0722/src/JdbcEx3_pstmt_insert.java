import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx3_pstmt_insert {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into dept values("
				+ "?, ?, ?)";
		
		try(Scanner sc = new Scanner(System.in)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("접속성공");
			pstmt = conn.prepareStatement(sql);
			System.out.println("부서 번호 입력");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("부서 이름 입력");
			pstmt.setString(2, sc.nextLine());
			System.out.println("부서 위치 입력");
			pstmt.setString(3, sc.nextLine());
			pstmt.executeUpdate();
			System.out.println("쿼리 성공");
			
		} catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
}
