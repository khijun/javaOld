<%@page import="project0730.Board"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String url = "jdbc:mysql://localhost:3307/spring5fs";
Connection con = null;
ResultSet rs = null;
PreparedStatement pstmt = null;

Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection(url, "root", "mysql");

String num = request.getParameter("num");
String sql = "select * from board where num = ?";
pstmt = con.prepareStatement(sql);
pstmt.setString(1, num);
rs = pstmt.executeQuery();
rs.next();
Board board = new Board(rs.getString("num"), rs.getString("writer"),rs.getString("title"),rs.getString("content"),rs.getString("regtime"),rs.getString("hits"));
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        input[type=text], textarea { width:100%; }
    </style>
</head>
<body>

<form method="post" action="update.jsp">
<input type = "hidden" name = "num" value = "<%=board.getNum() %>">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"  maxlength="80"
                       value="<%=board.getTitle()%>">
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" maxlength="20"
                       value="<%=board.getWriter()%>">
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10"><%=board.getContent()%></textarea>
            </td>
        </tr>
    </table>

    <br>
    <input type="submit" value="저장">
    <input type="button" value="취소" onclick="history.back()">
</form>

</body>
</html>