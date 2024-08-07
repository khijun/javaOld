<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>to 페이지</h1>
${kk }
<c:forEach var = "i" begin="1" end="10">
	${gugu } * ${i } = ${gugu*i }
</c:forEach>
</body>
</html>