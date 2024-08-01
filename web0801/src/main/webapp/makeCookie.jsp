<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie cookie = new Cookie("username", "박철수");
response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키만들기</title>
</head>
<body>
<%=cookie.getName() %>
<%=cookie.getValue() %>
</body>
</html>