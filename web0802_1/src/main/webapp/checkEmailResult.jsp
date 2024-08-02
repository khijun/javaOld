<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if("on".equals(request.getParameter("rememberMe"))){
	response.addCookie(Cookies.createCookie("email", request.getParameter("email"), "/", -1));
}else{
	response.addCookie(Cookies.createCookie("email", "", "/", 0));
}
	response.sendRedirect("checkEmail.jsp");
%>
