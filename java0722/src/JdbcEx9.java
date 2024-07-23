import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx9 {
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
			System.out.print("테이블 이름 입력: ");
			String str = sc.nextLine();
			String sql = String.format("select * from %s", str);
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numOfCol = rsmd.getColumnCount();
			System.out.println("컬럼의 수: "+numOfCol);
			for(int i = 1; i <= numOfCol; i++) {
				System.out.println(rsmd.getColumnName(i));
			}
			
			if(rs.next()) {
				do {
					System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				}while(rs.next());
				System.out.println("쿼리 성공");
			} else {
				System.out.println(str + "에 일치하는 데이터 없음");
			}
			
		} catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
	}
}
