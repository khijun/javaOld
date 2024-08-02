<%@page import="model.MemberDTO"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
request.setCharacterEncoding("utf-8");
MemberDAO dao = new MemberDAO();
MemberDTO oldDto = new MemberDTO(String.valueOf(session.getAttribute("userId")), "", "");
MemberDTO newDto = new MemberDTO("",request.getParameter("pw"),request.getParameter("name"));

dao.updateMember(oldDto, newDto);
session.setAttribute("userName", newDto.getName());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('수정이 완료되었습니다.');
    <%System.out.println(String.valueOf(session.getAttribute("userId")));%>
    opener.location.reload(true);  // 사용자 이름이 바뀌었으면 바로 반영
    window.close();
</script>

</body>
</html>