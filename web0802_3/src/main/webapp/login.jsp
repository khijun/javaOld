<%@page import="model.MemberDTO"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   

<%
MemberDAO dao = new MemberDAO();
MemberDTO dto = new MemberDTO(request.getParameter("id"), request.getParameter("pw"),"");
if (dao.login(dto)!=null) {
	dto = dao.getMemberInfo(dto);
    session.setAttribute("userId",   dto.getId());
    session.setAttribute("userName", dto.getName());
    
    response.sendRedirect("login_main.jsp");   
    return;
}
        
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>
