package du;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
@SuppressWarnings("serial")
public class JdbcUpdate extends HttpServlet{
	public static void main(String[] args) {
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("deptno"));
		int rDeptno = Integer.parseInt(req.getParameter("deptno"));
		String rDname = req.getParameter("dname");
		String rLoc = req.getParameter("loc");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into dept values(?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩");
			con = DriverManager.getConnection(url, "root", "mysql");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rDeptno);
			pstmt.setString(2, rDname);
			pstmt.setString(3, rLoc);
			int rs = pstmt.executeUpdate();
//			System.out.println(result + "건 성공");
			out.println(rs + "건 성공");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

