package du;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select")
@SuppressWarnings("serial")
public class JdbcSelect extends HttpServlet{
	public static void main(String[] args) {
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String getLoc = req.getParameter("loc");
		System.out.println(getLoc);
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select deptno, dname, loc from dept where loc like ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩");
			con = DriverManager.getConnection(url, "root", "mysql");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, getLoc);
			ResultSet rs = pstmt.executeQuery();
//			System.out.println(result + "건 성공");
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				String str = String.format("%d, %s, %s", deptno, dname, loc);
				out.println(str);
				out.print("\n");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

