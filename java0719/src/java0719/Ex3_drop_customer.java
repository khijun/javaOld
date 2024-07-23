package java0719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Ex3_drop_customer {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		String createString = "drop table customer";
		Statement stmt = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("접속성공");
			stmt = con.createStatement();
			int num = stmt.executeUpdate(createString);
			System.out.println(num);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//	create table customer