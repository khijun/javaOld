<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BoardDAO dao = new BoardDAO();
dao.deleteBoard(Integer.parseInt(request.getParameter("num")));
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