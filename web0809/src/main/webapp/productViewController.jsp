<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>
</head>
<body>

<table>
    <tr>
        <th>제품아이디</th>
        <td>${product.id }</td>
    </tr>
    <tr>
        <th>제품이름</th>
        <td>${product.name}</td>
    </tr>
    <tr>
        <th>설명</th>
		<td>${product.description}</td>
    </tr>
    <tr>
        <th>가격</th>
		<td>${product.price}</td>
    </tr>
    <tr>
        <th>재고</th>
		<td>${product.stock}</td>
    </tr>
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='products.jsp'">
</body>
</html>
