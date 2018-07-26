<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value='/InsertSupplier'/>"method="post">
<table align="center" cellspacing="3" class="table-striped">
<tr>
<td>Supplier Name</td>
<td><input type="text" name="suppname"/></td>
</tr>
<tr>
<td>Supplier Address</td>
<td><input type="text" name="suppaddr"/></td>
</tr>
<tr>
<td colspan="2">
<center>
<input type="submit" value="Insert Supplier"/>
</center>
</td>
</tr>


</table>

<table align="center" class="table-bordered">
<tr bgcolor="pink">
<td>Supplier ID</td>
<td>Supplier Name</td>
<td>Supplier Addr</td>
<td>Operation</td>
</tr>
<c:forEach items="${supplierList}" var="supplier">
<tr>
<td>${supplier.supplierId}</td>
<td>${supplier.supplierName}</td>
<td>${supplier.supplierAddr}</td>
<td>
<a href="<c:url value='/delete-${supplier.supplierId}-supplier'/>">Delete</a>
<a href="<c:url value='/edit-${supplier.supplierId}-supplier'/>">Edit</a>
<!--    <a href="<c:url value='/deleteCategory/${category.categoryId}'/>">Delete</a>
<a href="<c:url value='/editCategory/${category.categoryId}'/>">Edit</a>-->
</tr>
</c:forEach>


</table>
</form>
   
</body>
</html>