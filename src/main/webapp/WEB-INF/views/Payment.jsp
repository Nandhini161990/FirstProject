<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<tr bgcolor="orange">
<td colspan="4">Total Purchase Amount</td>
<td>INR.${totalPurchaseAmount}/-</td>
</tr>
</table>
</div>
<br/><br/><br/>
	<div class="container">
	<form action="<c:url value='/paymentProcess'/>" method="post">
		<table class="table" align="center" width="50%">
			<tr>
				<td colspan="2">Payment Option</td>
			</tr>
			<tr>
				<td colspan="2"><input type="radio" name="paymenttype"
					value="CC">Credit Card <input type="radio"
					name="paymenttype" value="CO">Cash On Delivery</td>
			</tr>
			<tr>
				<td>Card No:</td>
				<td><input type="text" name="cardno" required></td>
			</tr>
			<tr>
				<td>CVV</td>
				<td><input type="text" name="cvv"></td>
			</tr>
			<tr>
				<td>Valid Upto</td>
				<td><input type="text" name="valid"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Payment" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>