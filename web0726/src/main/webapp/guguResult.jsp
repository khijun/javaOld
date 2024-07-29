<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%int number = Integer.parseInt(request.getParameter("number")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>구구단 출력</h1>
<table border = "1">
<%
for(int i = 1; i < 10; i++){%>
<tr>
	<td><%=number %> * <%=i %> = <%=number * i %></td>
</tr>
<%}%>
</table>
</body>
</html>