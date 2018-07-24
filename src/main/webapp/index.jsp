 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="WEB-INF/views/Header.jsp" %>
<html>

<body>
<div id="samsungCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#samsungCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#samsungCarousel" data-slide-to="1"></li>
      <li data-target="#samsungCarousel" data-slide-to="2"></li>
    </ol>
 
    <!-- Wrapper for slides -->
    <div class="carousel-inner">
 
	  <div class="item active">
        <img src="<c:url value="/resources/images/images (5).jpg"/>"alt="samsung" style="width:100%"/>
        <div class="carousel-caption">
          <h3>HN Mobiles</h3>
        </div>
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/images/samsung.jpg"/>" alt="samsung" style="width:100%"/>
        <div class="carousel-caption">
          <h3>HN Mobiles</h3>
        </div>
      </div>
 
      <div class="item">
        <img src="<c:url value="/resources/images/iphone.jpg"/>" alt="samsung" style="width:100%"/>
        <div class="carousel-caption">
          <h3>HN Mobiles</h3>
        </div>
      </div>
  
    </div>
 
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#samsungCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#samsungCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<div class="row">
  <!-- <div class="col-md-4"> -->
  <div class="col-lg-4 col-md-4 col-xs-4 thumb">
    <div class="thumbnail">
       <a href="/resources/images/download.jpg"> 
        <img src="<c:url value="/resources/images/download.jpg"/>" alt="Lights" width="150" height="150">
        <!-- <div class="caption">
          <p>Lorem ipsum...</p>
        </div> -->
        
      </a>
     </div>
   </div> 
  <div class="col-lg-4 col-md-4 col-xs-4 thumb">
     <div class="thumbnail"> 
       <a href="/resources/images/images.jpg"> 
        <img src="<c:url value="/resources/images/images.jpg"/>" alt="Lights" width="150" height="150">
        <!-- <div class="caption">
          <p>Lorem ipsum...</p>
        </div> -->
      </a>
     </div> 
  </div>
  
  <div class="col-lg-4 col-md-4 col-xs-4 thumb">
     <div class="thumbnail"> 
       <a href="/resources/images/images (1).jpg"> 
        <img src="<c:url value="/resources/images/images (1).jpg"/>" alt="Lights" width="150" height="150">
        <!-- <div class="caption">
          <p>Lorem ipsum...</p>
        </div> -->
      </a>
     </div> 
  </div>
  <div class="col-lg-4 col-md-4 col-xs-4 thumb">
     <div class="thumbnail"> 
       <a href="/resources/images/images (2).jpg"> 
        <img src="<c:url value="/resources/images/images (2).jpg"/>" alt="Lights" width="250" height="250">
        <!-- <div class="caption">
          <p>Lorem ipsum...</p>
        </div> -->
      </a>
     </div> 
 </div>
   <div class="col-lg-4 col-md-4 col-xs-4 thumb">
     <div class="thumbnail"> 
       <a href="/resources/images/images (3).jpg"> 
        <img src="<c:url value="/resources/images/images (3).jpg"/>" alt="Lights" width="200" height="200">
        <!-- <div class="caption">
          <p>Lorem ipsum...</p>
        </div> -->
      </a>
    </div> 
  </div>
<!-- <h2>hi</h2> -->
</body>
</html>
