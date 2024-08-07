<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setAttribute("kk", "김하나");
request.setAttribute("gugu", "7");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>끼얏호우</h1>
<jsp:forward page="to.jsp"/>
</body>
</html>