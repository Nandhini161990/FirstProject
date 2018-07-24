<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
	<div class="container">
		<table class="table">
			<tr bgcolor="lightblue">
				<td colspan="6"><center>
						<h3>Receipt</h3>
					</center></td>
			</tr>
			<tr>
				<td colspan="2">Order ID</td>
				<td>${orderDetail.orderId}</td>
				<td colspan="2">Order Date</td>
				<td>${orderDetail.orderDate}</td>
			</tr>
			<tr bgcolor="orange">
				<td colspan="4">Total Purchase Amount</td>
				<td>INR.${totalPurchaseAmount}/-</td>
			</tr>

			<tr>
				<td>#SL</td>
				<td>Product Name</td>
				<td>Quantity</td>
				<td>Price</td>
				<td>Total Price</td>

			</tr>
			<c:if test="${empty cartItems}">
				<tr bgcolor="pink">
					<td colspan="5"><center>
							<h4>!!! Your Cart is Empty</h4>
						</center></td>
				</tr>
			</c:if>
			<c:if test="${not empty cartItems}">
				<c:forEach items="${cartItems}" var="cartItem">
					<%-- <form action="<c:url value='/updateCartItem-${cartItem.cartItemId}-cartItem'/>"method="POST"> --%>
					<c:url var="updateAction" value="/updateCartItem"></c:url>
					<form:form action="${updateAction}" method="post">
						<tr>
							<td></td>
							<td>${cartItem.productName}</td>
							<td>${cartItem.quantity}</td>
							<td>${cartItem.price}</td>
							<td>${cartItem.quantity * cartItem.price}</td>

						</tr>
					</form:form>
				</c:forEach>
			</c:if>
			<tr bgcolor="orange">
				<td colspan="4">Total Purchase Amount</td>
				<td colspan="2">INR.${totalPurchaseAmount}/-</td>
			</tr>
			<tr bgcolor="cyan">
				<td colspan="6"><center>Thanks for Shopping Here.Hope
						To See You Again</center></td>
			</tr>
		</table>
	</div>
	<br />
	<br />
	<br />
</body>
</html>