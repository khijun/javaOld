<%@page import="project0730.Board"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String url = "jdbc:mysql://localhost:3307/spring5fs";
Connection con = null;
ResultSet rs = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection(url, "root", "mysql");
String sql = "delete from board where num = ?";
pstmt = con.prepareStatement(sql);
pstmt.setString(1,request.getParameter("num"));
pstmt.executeUpdate();

response.sendRedirect("list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>삭제 완료</h1>
	<form><input type="button" value="이전" onclick="location.href='list.jsp'"></form>
</body>
</html>