<%@page import="java.sql.SQLSyntaxErrorException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name;
int num, kor, eng, math;
Connection con = null;
PreparedStatement pstmt = null;
String url = "jdbc:mysql://localhost:3307/spring5fs";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection(url, "root", "mysql");
	String sql = "insert into score values(?,?,?,?,?)";
	name = request.getParameter("name");
	num=Integer.parseInt(request.getParameter("num"));
	kor=Integer.parseInt(request.getParameter("kor"));
	eng=Integer.parseInt(request.getParameter("eng"));
	math=Integer.parseInt(request.getParameter("math"));
	if("".equals(name)||num<0||kor<0||eng<0||math<0){
		throw new Exception();
	}
	pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, num);
	pstmt.setString(2, name);
	pstmt.setInt(3, kor);
	pstmt.setInt(4, eng);
	pstmt.setInt(5, math);
	pstmt.executeUpdate();
	%><h1>데이터 삽입 성공!</h1>
	<table border = "1"><tr>
	<td><%=num %></td>
	<td><%=name %></td>
	<td><%=kor %></td>
	<td><%=eng %></td>
	<td><%=math %></td>
	</tr></table>
	<form action = "insertForm.jsp">
	<input type = "submit" value = "이전">
	</form><%
}catch(SQLException e){
	%><h1>DB연결 실패.</h1><br>
	<form action = "insertForm.jsp">
	<input type = "submit" value = "이전">
	</form><%
}catch(Exception e){
	%><h1>값이 부적절함.</h1><br>
	<form action = "insertForm.jsp">
	<input type = "submit" value = "이전">
	</form><%
}

%>
</body>
</html>