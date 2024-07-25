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
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");	// 인코딩방식 utf-8로 설정
		PrintWriter out = response.getWriter();
		Account account = null;
		String name, ssn, tel;
		if(!(name = request.getParameter("name")).equals("")&& !(ssn = request.getParameter("ssn")).equals("")&&
		!(tel = request.getParameter("tel")).equals("")){
			account = new Account(name,ssn,tel);
		}
		
		out.println("<html>");
		out.println("<body>");
		out.println(account!=null?"<h1>회원가입 성공</h1>":"<h1>회원가입 실패</h1>");
		out.println("<form action = \"/web0725_1/index.jsp\">");
		out.println("<input type=\"submit\" value=\"이전\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		if(account == null)
			return;
		
		
		String url = "jdbc:mysql://localhost:3307/spring5fs";
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into account(name, ssn, tel, balance) values(?,?,?,0)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "mysql");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account.getName());
			pstmt.setString(2, account.getSsn());
			pstmt.setString(3, account.getTel());
			int rs = pstmt.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
