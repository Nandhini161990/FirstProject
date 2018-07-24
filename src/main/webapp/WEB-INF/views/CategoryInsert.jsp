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
<form action="<c:url value='/InsertCategory'/>"method="post">
<table align="center" cellspacing="3" class="table-striped">
<tr>
<td>Category Name</td>
<td><input type="text" name="catname"/></td>
</tr>
<tr>
<td>Category Description</td>
<td><input type="text" name="catDesc"/></td>
</tr>
<tr>
<td colspan="2">
<center>
<input type="submit" value="Insert Category"/>
</center>
</td>
</tr>


</table>

<table align="center" class="table-bordered">
<tr bgcolor="pink">
<td>Category ID</td>
<td>Category Name</td>
<td>Category Desc</td>
<td>Operation</td>
</tr>
<c:forEach items="${categorylist}" var="category">
<tr>
<td>${category.categoryId}</td>
<td>${category.categoryName}</td>
<td>${category.categoryDesc}</td>
<td>
<a href="<c:url value='/delete-${category.categoryId}-category'/>">Delete</a>
<a href="<c:url value='/edit-${category.categoryId}-category'/>">${category.categoryId}</a>
<!--    <a href="<c:url value='/deleteCategory/${category.categoryId}'/>">Delete</a>
<a href="<c:url value='/editCategory/${category.categoryId}'/>">Edit</a>-->
</tr>
</c:forEach>


</table>
</form>
   
</body>
</html>