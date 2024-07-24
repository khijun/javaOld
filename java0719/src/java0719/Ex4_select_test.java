package java0719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Ex4_select_test {
	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		String createString = "select * from dept where loc = '";
		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		try (Scanner sc = new Scanner(System.in)){
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속성공");
			System.out.print("지역명입력");
			String input = sc.nextLine();
			stmt = con.createStatement();
			rs = stmt.executeQuery(createString + input + "'");
			while(rs.next()) {
				System.out.println(String.format("%d, %s, %s", rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//	create table customer