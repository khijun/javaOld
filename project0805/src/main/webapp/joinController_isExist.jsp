<%@page import="model.MemberDAO"%>
<%@page import="model.MemberCon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
<%
MemberCon memberCon = new MemberDAO();
%>
alert("존재하지 않는 아이디입니다.");
window.close();
alert("존재하는 아이디입니다.");
window.close();
</script>