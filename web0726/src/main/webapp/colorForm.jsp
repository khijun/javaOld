<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>색깔을 선택하세요</title>
<style>
body{
background: <%=request.getParameter("color") %>;
}
</style>
</head>
<body>
<h2>If-else Example</h2>
<form action="colorResult.jsp" method = "post">
이름:<input type = "text" name = "name"><br>
좋아하는 색깔:<select name="color" id = "color">
<option value = "red">빨간색</option>
<option value = "orange">주황색</option>
<option value = "yellow">노란색</option>
<option value = "green">초록색</option>
<option value = "blue">파란색</option>
<option value = "darkblue">남색</option>
<option value = "purple">보라색</option>
<option value = "white">흰색</option>

</select><br>
<input type = "submit" value="보내기">
</form>
</body>
</html>