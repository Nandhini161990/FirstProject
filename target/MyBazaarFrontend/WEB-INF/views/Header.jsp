<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.mycontainer{
background-color:orange;
}
</style>
</head>
<body>
<div class="container" class="container">
social icon
</div>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="#">MyBazaar</a> 
</div>
<ul class="nav navbar-nav">

<li class="active"><a href="home">Home</a>
<li><a href="login">Login</a></li>
<li><a href="register">Register</a></li>
<li><a href="contactus">Contact Us</a></li>
<li><a href="aboutus">About Us</a></li>
<li><a href="category">Category</a></li>
<li><a href="product">Manage Product</a></li>
</ul>
</div>
<div class = "nav navbar-nav navbar-right">
<font color="white" face="calibri" size="2">Welcome:</font>
<a href="/logout">LOGOUT</a>
</div>
</nav>
</body>
</html>