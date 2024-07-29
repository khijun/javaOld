<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>While Example</h2>
<%
int count = 0;
while(count < Integer.parseInt(request.getParameter("repeat"))){
%>
	<%=request.getParameter("str")%><br>
<% count++; } %>
</body>
</html>