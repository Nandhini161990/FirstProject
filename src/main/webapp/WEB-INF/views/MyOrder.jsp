<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="container">
<table class="table">
<tr>
<td colspan="6"><center><h3> Your Order </h3></center></td>
</tr>
<tr>
<td> SL# </td>
<td> Product Name </td>
<td> Quantity </td>
<td> Price </td>
<td> Total Price </td>
<td> Operation </td>
<c:if test="${empty cartItems}">
<tr><td colspan="6"><center>!!! Your Cart is Empty</center></td></tr>
</c:if>
<c:if test="${not empty cartItems}">
<c:forEach items="${cartItems}" var="cartItem">
<%-- <form action="<c:url value='/updateCartItem-${cartItem.cartItemId}-cartItem'/>"method="POST"> --%>
<c:url var="updateAction" value="/updateCartItem" ></c:url>
<form:form action ="${updateAction}" method="post">
<tr>
<td></td>
<td>${cartItem.productName}</td>
<td><input type="text" value="${cartItem.quantity}" name="quantity"/></td>
<td>${cartItem.price}</td>
<td>${cartItem.quantity * cartItem.price}</td>
<td>
<input type="submit" value="Update" class="btn-btn-primary"/>
<a href="<c:url value='/deleteCartItem-${cartItem.cartItemId}-cartItem'/>" class="btn-btn-danger">Delete</a>
<input type="hidden" value="${cartItem.cartItemId}" name="cartItemId"/>
</td>
</tr>
</form:form>
</c:forEach>
</c:if>
<tr bgcolor="orange">
<td colspan="4">Total Purchase Amount</td>
<td>${totalPurchaseAmount}</td>
</tr>
<tr bgcolor="lightblue">
<td colspan="3"><a href="<c:url value='/continueShopping'/>" class="btn-btn-info">Continue Shopping</a></td>
<td colspan="3"><a href="<c:url value='/payment'/>" class="btn-btn-info">Payment</a></td>
<%-- <td colspan="3"><a href="<c:url value='/checkout'/>" class="btn-btn-info">CheckOut</a></td> --%>
</tr>
</table>
</div>

</table>
</div>
</body>
</html>