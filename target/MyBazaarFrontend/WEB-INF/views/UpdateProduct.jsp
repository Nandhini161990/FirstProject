<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action=<c:url value='/UpdateProduct/'/> modelAttribute="product" method="post">
<table align="center" cellspacing="3">
<tr>
<td colspan="2">Product Manage</td>
</tr>
<tr>
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
<td><form:input path="supplierid"/></td>
</tr>
<tr>
<td>
<input type="submit" value="Update"/>
</td>
</tr>
</table>
</form:form>
</body>
</html>