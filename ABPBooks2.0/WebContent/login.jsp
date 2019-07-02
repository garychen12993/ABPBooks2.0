<%@page import="util.MySQLJDBC"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>User Login</title>
<head>
  <%@ include file="templates/template-meta.jsp"%>
</head>
<body>

<%@ include file="templates/template-header.jsp"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="home.jsp">ABP</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="studentHome.jsp"><span class="glyphicon glyphicon-search"></span> Search</a></li>
        <li><a href="<%=request.getContextPath()%>/CartController?action=display"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-list-alt"></span> List</a></li>
        <li><a href="loans.jsp"><span class="glyphicon glyphicon-book"></span> Loans</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
<br>
	${message}<br>
	${successMessage}<br>
	<form class="form-horizontal" action="<%=request.getContextPath()%>/LoginController" method="post" onsubmit="return administratorLoginValidate()">
	<fieldset>
	<legend>Student Login</legend>
		<div class="form-group">
			<label class="control-label col-sm-2" for="id">ID:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="id" name="id">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="password">Password:</label>
			<div class="col-sm-10">          
				<input type="password" class="form-control" id="password" name="password">
			</div>
		</div>
		
		<div class="form-group">        
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" name="submit" value="login" class="btn btn-primary">Login</button>
				<button class="btn btn-primary" type="submit" formaction="<%=request.getContextPath()%>/register.jsp">Register</button>
			</div>
		</div>
		<a href="<%=request.getContextPath()%>/administratorlogin.jsp">Administrator Login</a>
	</fieldset>
	</form>
	
</div><br><br>

<footer class="container-fluid text-center">
<%@ include file="templates/template-footer.jsp"%>
</footer>

</body>
</html>