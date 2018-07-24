<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="Header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
 <div class = "row">
 <c:forEach items="${productList}" var="product">
<div class="col-sm-6 col-md-4">
<div class="thumbnail">
<h4>
<b class="glyphicon glyphicon-star"></b>

    

<span data-toggle="tooltip" title="Bootstrap version" >${product.productName} &nbsp;${product.price}</span>

</h4>
<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="150" height="150" alt="Image not supported"/>
<a href="<c:url value='/totalProductInfo-${product.productId}-product'/>" class="btn btn-primary col-xs-12">Click for Large</a>
 
   <div class="clearfix"></div>
</div>
</div>
</c:forEach>
</div>

<!------ Include the above in your HEAD tag ---------->

<!--   <div class="container">
    <div class="row">
		<div class="well">
        <h1 class="text-center">Vote for your favorite</h1>
        <div class="list-group">
          <a href="#" class="list-group-item active">
                <div class="media col-md-3">
                    <figure class="pull-left">
                        <img class="media-object img-rounded img-responsive"  src="http://placehold.it/350x250" alt="placehold.it/350x250" >
                    </figure>
                </div>
                <div class="col-md-6">
                    <h4 class="list-group-item-heading"> List group heading </h4>
                    <p class="list-group-item-text"> Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea ea, viris timeam molestiae an has. At nisl platonem eum. 
                        Vel et nonumy gubergren, ad has tota facilis probatus. Ea legere legimus tibique cum, sale tantas vim ea, eu vivendo expetendis vim. Voluptua vituperatoribus et mel, ius no elitr deserunt mediocrem. Mea facilisi torquatos ad.
                    </p>
                </div>
                <div class="col-md-3 text-center">
                    <h2> 14240 <small> votes </small></h2>
                    <button type="button" class="btn btn-default btn-lg btn-block"> Vote Now! </button>
                    <div class="stars">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </div>
                    <p> Average 4.5 <small> / </small> 5 </p>
                </div>
          </a>
          <a href="#" class="list-group-item">
                <div class="media col-md-3">
                    <figure class="pull-left">
                        <img class="media-object img-rounded img-responsive" src="http://placehold.it/350x250" alt="placehold.it/350x250" >
                    </figure>
                </div>
                <div class="col-md-6">
                    <h4 class="list-group-item-heading"> List group heading </h4>
                    <p class="list-group-item-text"> Eu eum corpora torquatos, ne postea constituto mea, quo tale lorem facer no. Ut sed odio appetere partiendo, quo meliore salutandi ex. Vix an sanctus vivendo, sed vocibus accumsan petentium ea. 
                        Sed integre saperet at, no nec debet erant, quo dico incorrupte comprehensam ut. Et minimum consulatu ius, an dolores iracundia est, oportere vituperata interpretaris sea an. Sed id error quando indoctum, mel suas saperet at.                         
                    </p>
                </div>
                <div class="col-md-3 text-center">
                    <h2> 12424 <small> votes </small></h2>
                    <button type="button" class="btn btn-primary btn-lg btn-block">Vote Now!</button>
                    <div class="stars">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </div>
                    <p> Average 3.9 <small> / </small> 5 </p>
                </div>
          </a>
          <a href="#" class="list-group-item">
                <div class="media col-md-3">
                    <figure class="pull-left">
                        <img class="media-object img-rounded img-responsive" src="http://placehold.it/350x250" alt="placehold.it/350x250">
                    </figure>
                </div>
                <div class="col-md-6">
                    <h4 class="list-group-item-heading"> List group heading </h4>
                    <p class="list-group-item-text"> Ut mea viris eripuit theophrastus, cu ponderum accusata consequuntur cum. Suas quaestio cotidieque pro ea. Nam nihil persecuti philosophia id, nam quot populo ea. 
                        Falli urbanitas ei pri, eu est enim volumus, mei no volutpat periculis. Est errem iudicabit cu. At usu vocibus officiis, ad ius eros tibique appellantur.                         
                    </p>
                </div>
                <div class="col-md-3 text-center">
                    <h2> 13540 <small> votes </small></h2>
                    <button type="button" class="btn btn-primary btn-lg btn-block">Vote Now!</button>
                    <div class="stars">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </div>
                    <p> Average 4.1 <small> / </small> 5 </p>
                </div>
          </a>
        </div>
        </div>
	</div>
</div>-->
</body>
</html>