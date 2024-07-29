<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int kor,eng,math;
Connection con = null;
PreparedStatement pstmt = null;
String url = "jdbc:mysql://localhost:3307/spring5fs";
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection(url, "root", "mysql");
String sql = "select * from score";
pstmt = con.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학생 테이블</h1>
<table border = "1">
<tr>
<th>학생 이름</th><th>국어</th><th>영어</th><th>수학</th><th>총점</th><th>평균</th>
</tr>
<%
while(rs.next()){
	%><tr>
	<td><%=rs.getString("name") %></td>
	<td><%=kor = Integer.parseInt(rs.getString("kor")) %></td>
	<td><%=eng = Integer.parseInt(rs.getString("eng")) %></td>
	<td><%=math = Integer.parseInt(rs.getString("math")) %></td>
	<td><%=kor+eng+math %></td>
	<td><%=String.format("%.3f",((double)(kor+eng+math)/3)) %></td>
	</tr>
<%}%>
</table>
</body>
</html>