<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String temp;
int curr = (temp = (request.getParameter("curr")))==null?1:Integer.parseInt(temp);
for(int i = curr-2; i <= curr+2; i++){
	if(!(i<1||i>10)){%>
		<button onclick = "window.location.href='/web0725_1/select.jsp?curr=<%=i %>'">
		<%=i %></button>
<%}}%>
</body>	
</html>