<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>홈페이지</h1>
<form action="<%=request.getContextPath() %>/First">
이름: <input type = "text" name = "name"><br>
비번: <input type = "text" name = "ssn"><br>
<input type="submit" value = "로그인">
</form>
<form action="/web0725_1/register.jsp">
<input type="submit" value = "회원가입">
</form>
</body>
</html>