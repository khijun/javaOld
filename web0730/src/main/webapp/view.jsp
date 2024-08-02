<%@page import="project0730.Board"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String num = request.getParameter("num");
String url = "jdbc:mysql://localhost:3307/spring5fs";
Connection con = null;
ResultSet rs = null;
PreparedStatement pstmt = null;

Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection(url, "root", "mysql");
String sql = "update board set hits = hits + 1 where num = ?";
pstmt = con.prepareStatement(sql);
pstmt.setString(1,num);
pstmt.executeUpdate();	
sql = "select * from board where num = ?";
pstmt = con.prepareStatement(sql);
pstmt.setString(1,num);
rs = pstmt.executeQuery();	
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>
</head>
<body>

<table>
<%
rs.next();
Board board = new Board(rs.getString("num"), rs.getString("writer"),rs.getString("title"),rs.getString("content"),rs.getString("regtime"),rs.getString("hits"));
%>
    <tr>
        <th>제목</th>
        <td><%=board.getTitle() %></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=board.getWriter() %></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=board.getRegtime() %></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=board.getHits() %></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=board.getContent() %></td>
    </tr>
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='list.jsp'">
<input type="button" value="수정"
       onclick="location.href='write2.jsp?num=<%=board.getNum()%>'">
<input type="button" value="삭제"
       onclick="location.href='delete.jsp?num=<%=board.getNum()%>'">

</body>
</html>
