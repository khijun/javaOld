<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
</head>
<body>
<c:choose>

<c:when test = "${product == null }"><form action="insertProduct.jsp" method="post"></c:when>
<c:otherwise><form action="updateProduct.jsp" method="post"></c:otherwise>
</c:choose>
		<div>
			<c:if test="${product != null }"><input type = "hidden" name = "id" id="id" value="${product.id }"></c:if> 
			<c:if test="${id != null}"><input type = "hidden" name = "id" id="id" value="${id }"></c:if>
			<label for="name">제품명:</label> <input type="text" id="name"
				name="name" value="${product.name }" required>
		</div>
		<div>
			<label for="description">설명:</label>
			<textarea id="description" name="description" required>${product.description }</textarea>
		</div>
		<div>
			<label for="price">가격:</label> <input type="text" id="price"
				name="price" value="${product.price }" required>
		</div>
		<div>
			<label for="stock">수량:</label>
			<c:choose> 
				<c:when test="${product!=null }">
					<input type="text" id="stock" name="stock" value="${product.stock}" required>
				</c:when>
				<c:otherwise>
					<input type="text" id="stock" name="stock" value="0" required>
				</c:otherwise>
			</c:choose>
			
		</div>
		<div>
			<c:choose>
			<c:when test="${product == null }"><input type="submit" value="Add Product"></c:when>
			<c:otherwise><input type="submit" value="Update Product"></c:otherwise>
			</c:choose>
		</div>
	</form>
</body>
</html>