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
<%-- <c:if test="$(flag)">--%>
<form action="<c:url value='/UpdateCategory'/>"method="post">
<table>
<tr>
<td>Category Id</td>
<td><input type="text" name="catid" value="${categoryData.categoryId}" readonly></td>
</tr>
<tr>
<td>Category Name</td>
<td><input type="text" name="catname" value="${categoryData.categoryName}"/></td>
</tr>
<tr>
<td>Category Description</td>
<td><input type="text" name="catDesc" value="${categoryData.categoryDesc}"/></td>
</tr>
<tr>
<td colspan="2">
<center>
<input type="submit" value="Update Category"/>
</center>
</td>
</tr>


</table>

</form>
<%-- </c:if>--%>
 <%--  <c:if test="$(flag)">
<form action="<c:url value='/InsertCategory'/>"method="post">
<table>
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

<table>
<tr>
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
<a href="<c:url value='/deleteCategory/${category.categoryId}'/>">Delete</a>
<a href="<c:url value='/editCategory/${category.categoryId}'/>">Edit</a>
</tr>
</c:forEach>


</table>
</form>
   </c:if>--%>
</body>
</html>