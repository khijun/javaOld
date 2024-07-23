package java0719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Ex4_select_test {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		String createString = "select * from test";
		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("접속성공");
			stmt = con.createStatement();
			rs = stmt.executeQuery(createString);
			rs.next();
			System.out.println("테이블에 삽입"+rs.getString("test"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//	create table customer