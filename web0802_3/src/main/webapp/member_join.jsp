<%@page import="model.MemberDTO"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<%
request.setCharacterEncoding("utf-8");
MemberDAO dao = new MemberDAO();
MemberDTO dto = new MemberDTO(request.getParameter("id"), request.getParameter("pw"), request.getParameter("name"));
if (dao.isExist(dto)) {   
%>
<script>
	alert('이미 등록된 아이디입니다.');
	history.back()
</script>
<%          
} else {           
dao.joinMember(dto);
}
%>
<script>
	alert('가입이 완료되었습니다.');
	window.close();
</script>
</body>
</html>