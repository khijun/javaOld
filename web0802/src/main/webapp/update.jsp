<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
BoardDAO dao = new BoardDAO();
dao.updateBoard(
new BoardDTO(Integer.parseInt(request.getParameter("num")),
request.getParameter("writer"),
request.getParameter("title"),
request.getParameter("content"),
"",0));
response.sendRedirect("list.jsp");
%>
