package du;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First
 */
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public First() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");	// 인코딩방식 utf-8로 설정
		PrintWriter out = response.getWriter();
		Account account = null;
		
		String strName = request.getParameter("name");
		String strSsn = request.getParameter("ssn");
		
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select * from account where name = ? and ssn = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "mysql");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, strName);
			pstmt.setString(2, strSsn);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				account = new Account(rs.getInt("id"), rs.getString("name"),rs.getString("ssn"),
						rs.getString("tel"),rs.getInt("balance"));
				String str = String.format("%d, %s, %s, %s, %d\n", account.getId(), account.getName(),
						account.getSsn(), account.getTel(), account.getBalance());
				System.out.println(str);
			}
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
//		LoginSession.name = str;
//		LoginSession.ssn = strSsn;
		out.println("<html>");
		out.println("<h1>테스트</h1>");
		out.println(account!=null?
				"<h1>" + account.getName() + "님 환영합니다." + "</h1>":
				"<h1>로그인 실패</h1>");
		out.println("<body>");
		out.println("<table border = '1'>");
		out.println("<tr>");
		if(account != null) {
			out.println("<td>" + account.getId() +"</td>");
			out.println("<td>" + account.getName() +"</td>");
			out.println("<td>" + account.getSsn() +"</td>");
			out.println("<td>" + account.getTel() +"</td>");
			out.println("<td>" + account.getBalance() +"</td>");
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
