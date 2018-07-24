<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="Header.jsp" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<%-- <form action="<c:url value='/addToCart-${product.productId}-product'/>"method="POST"> --%>
<table class="table" border="1">
<tr>
<td rowspan="9">
<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="300" height="300" alt="Image not supported"/>
</td>
</tr>
<%-- <form action="<c:url value="/addToCart/${product.productId}"/> method="get"> --%>
<tr>
<td>Product ID</td>
<td>${product.productId}</td>
</tr>
<tr>
<td>Product Description</td>
<td>${product.productDesc}</td>
</tr>
<tr>
<td>Product Name</td>
<td>${product.productName}</td>
</tr>
<tr>
<td>Supplier ID</td>
<td>${product.supplierId}</td>
</tr>
<tr>
<td>Stock</td>
<td>${product.stock}</td>
</tr>
<tr>
<td>Category</td>
<td>${categoryName}</td>
</tr>
 <%-- <c:url var="addAction" value="/addToCart/${product.productId}" ></c:url> --%>
 <c:url var="addAction" value="/addToCart" ></c:url>
<form:form action ="${addAction}" method="post">
 <%-- <form action="<c:url value='/addToCart/${product.productId}'/>" method="get">   --%>
 <%-- <form action="<c:url value='/addToCart/{productId}'/>"method="POST"> --%>
<tr>
<td>Quantity</td>
<td>
<select name="quantity" class="form-control btn-block">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
</td>
</tr>
<tr>
<%-- <input type="hidden" value="${product.productId}" name="productId"/> --%>
<td colspan="2">
<input type="submit" value="AddToCart" class="btn btn-info btn-block"/>
<input type="hidden" value="${product.productId}" name="productId"/>
</td>
</tr>
</form:form>
</table>

</div>
</body>
</html>