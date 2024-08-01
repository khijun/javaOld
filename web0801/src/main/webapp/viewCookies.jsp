<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 목록</title>
</head>
<body>
<%
if(cookies != null && cookies.length>0){
	for(int i=0;i<cookies.length;i++){
		out.println(cookies[i].getName() + "=");
		out.println(cookies[i].getValue() + "<br>");
	}
}
%>
</body>
</html>