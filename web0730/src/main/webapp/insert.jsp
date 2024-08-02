<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
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

String sql = "insert into board(writer, title, content, regtime,hits) values(?,?,?,?,0)";
pstmt = con.prepareStatement(sql);
pstmt.setString(1,request.getParameter("writer"));
pstmt.setString(2,request.getParameter("title"));
pstmt.setString(3,request.getParameter("content"));
pstmt.setString(4,DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(LocalDateTime.now()));
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
	<h1>저장 완료</h1>
	<form><input type="button" value="이전" onclick="location.href='list.jsp'"></form>
</body>
</html>