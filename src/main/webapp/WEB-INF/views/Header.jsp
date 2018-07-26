<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
#mycontainer{
background-color:orange;
}
</style>
</head>
<body>
<div id="mycontainer" class="container">
social icon
</div>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
<a class="navbar-brand" href="#">MyBazaar</a> 
</div>
<ul class="nav navbar-nav">

<li class="active"><a href="home">Home</a></li>
<%-- <security:authorize access="isAnonymous()"> --%>
<c:if test="${!sessionScope.loggedIn}">
<li class="nav-item-active"><a class="nav-link" href="login">Login</a>
</li>
<%-- </security:authorize> --%>
 <%-- <security:authorize access="isAuthenticated()"> --%>
<!-- <li class="nav-item-active"><a class="nav-link" href="logout">LOGOUT</a>
</li> -->
<%-- </security:authorize>  --%>
<!--  <li><a href="login">Login</a></li>-->
<li><a href="register">Register</a></li>
<li><a href="contactus">Contact Us</a></li>
<li><a href="aboutus">About Us</a></li>
</c:if>
<c:if test="${sessionScope.loggedIn}">
<c:if test="${sessionScope.role == 'ROLE_ADMIN'}">
<li><a href="category">Manage Category</a></li>
<li><a href="product">Manage Product</a></li>
<li><a href="supplier">Manage Supplier</a></li>
</c:if>
<c:if test="${sessionScope.role == 'ROLE_USER'}">
<li><a href="productDisplay">Display Product</a></li>
</c:if>
</c:if>
</ul>
</div>
<div class = "nav navbar-nav navbar-right">
<c:if test="${sessionScope.loggedIn}">
<font color="white" face="calibri" size="2">Welcome:${username}</font>
<a href="logout"><font color="white" face="calibri" size="3">LOGOUT</font></a> 
</c:if>
<!-- <a href="/logout">LOGOUT</a> -->
</div>
</nav>
<!-- <div class="container"> -->
 <!--  <h1>Bootstrap Carousel - SpringBoot</h1> -->
  
  <!-- </div> -->
  
</body>
</html>