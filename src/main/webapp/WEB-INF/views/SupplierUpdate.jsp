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
<form action="<c:url value='/UpdateSupplier'/>"method="post">
<table align="center" cellspacing="3" class="table-striped">
<%-- <form:hidden path="categoryId"/> --%>
 <tr>
<td>Supplier Id</td>
<td><input type="text" name="suppid" value="${supplierData.supplierId}" readonly></td>
</tr> 
<tr>
<td>Supplier Name</td>
<td><input type="text" name="suppname" value="${supplierData.supplierName}"/></td>
</tr>
<tr>
<td>Supplier Address</td>
<td><input type="text" name="suppAddr" value="${supplierData.supplierAddr}"/></td>
</tr>
<br/><br/>
<tr>
<td colspan="2">
<center>
<input type="submit" value="Update Supplier"/>
</center>
</td>
</tr>


</table>

</form>
</body>
</html>