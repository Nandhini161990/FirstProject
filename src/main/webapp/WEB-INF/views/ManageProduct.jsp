<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="ProductInsert" modelAttribute="product" method="post" enctype="multipart/form-data">
<table align="center" cellspacing="3" class="table-striped">
<tr bgcolor="pink">
<td colspan="2" align="center"><b>Product Manage</b></td>
</tr>
<tr>
<form:hidden path="productId"/>
<td colspan="2">Product Name</td>
<td><form:input path="productName"/></td>
</tr>
<tr>
<td colspan="2">Product Description</td>
<td><form:input path="productDesc"/></td>
</tr>

<tr>
<td colspan="2">Price</td>
<td><form:input path="price"/></td>
</tr>
<tr>
<td colspan="2">Stock</td>
<td><form:input path="stock"/></td>
</tr>
<tr>
<td colspan="2">Category</td>
<td>
<form:select path="categoryId">
<form:option value="0" label="--Select List--"/>
<form:options items="${categoryList}"/>
</form:select>
</td>
</tr>
<tr>
<td colspan="2">Supplier</td>
<td><form:input path="supplierId"/></td>
</tr>
<tr>
<td>Product Image</td>
<td><form:input type="file" path="pimage"/></td>
<tr>
<td>

<input type="submit" value="Save" class="btn btn-info"  />
</td>
</tr>
</table>
</form:form>
<table align="center" class="table-bordered">
<tr bgcolor="pink">
<td>Product Id</td>
<td>Product Name</td>
<td>Product Desc</td>
<td>Price</td>
<td>Stock</td>
<td>Category</td>
<td>Supplier</td>
<td>Operation</td>
</tr>
<c:forEach items="${productList}" var="product">
<tr>
<td>${product.productId}</td>
<td>${product.productName}</td>
<td>${product.productDesc}</td>
<td>${product.price}</td>
<td>${product.stock}</td>
<td>${product.categoryId}</td>
<td>${product.supplierId}</td>
<td>
<a href="<c:url value='/delete-${product.productId}-product'/>">Delete</a>
<a href="<c:url value='/edit-${product.productId}-product'/>">Edit</a>
<%-- <a href="<c:url value='/deleteProduct/${product.productId}'/>">Delete</a>
<a href="<c:url value='/editProduct/${product.productId}'/>">Edit</a>--%>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>