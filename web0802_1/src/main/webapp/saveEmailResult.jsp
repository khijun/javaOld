<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.addCookie(Cookies.createCookie("email", request.getParameter("email"), "/", -1));
response.sendRedirect("saveEmail.jsp");
%>
