<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("name", "홍길동");
	request.setAttribute("money", 5000);
	request.setAttribute("dataList", new String[]{"a", "b", "c"});
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${name == '홍길동' }">
	이름은 홍길동입니다.<br>
</c:if>
<c:choose>
	<c:when test = "${money >= 10000 }">
		돈많아요.
	</c:when>
	<c:when test="${money>0 }">
		돈조금있어요.
	</c:when>
	<c:otherwise>
		돈 하나도 없어요
	</c:otherwise>
</c:choose>
<c:forEach var="count" begin="0" end="30" step="3">
	${count }
</c:forEach>
${dan = 4;''}
<br>
<c:forEach var="i" begin="1" end="10">
	${dan} * ${i } = ${dan*i }<br>
</c:forEach>
</body>
</html>