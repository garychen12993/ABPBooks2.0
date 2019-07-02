<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Register</title>
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
	<form class="form-horizontal" action="<%=request.getContextPath()%>/RegisterController" method="post" onsubmit="return administratorLoginValidate()">
	<fieldset>
	<legend>Registration</legend>
		<div class="form-group">
			<label class="control-label col-sm-2" for="id">NetID:</label>
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
			<label class="control-label col-sm-2" for="retry-password">Retype Password:</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="retry-password" name="retry-password">
			</div>
		</div>
		<br>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="firstname">First Name:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="firstname" name="firstname">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="lastname">Last Name:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="lastname" name="lastname">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="email" name="email">
			</div>
			<div id="email_error"></div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="bridgeyear">Bridge Year:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="bridgeyear" name="bridgeyear">
			</div>
			<div id="email_error"></div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="major">Major:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="major" name="major">
			</div>
			<div id="email_error"></div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="street">Address:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="address" name="address">
			</div>
		</div>
		<!-- <div class="form-group">
			<label class="control-label col-sm-2" for="street">Street:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="street" name="street">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="city">City:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="city" name="city">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="state">State:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="state" name="state">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="zip">Zip:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="zip" name="zip">
			</div>
		</div>-->
		<div class="form-group">
			<label class="control-label col-sm-2" for="phone">Phone:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="phone" name="phone">
			</div>
		</div>
		
		<div class="form-group">        
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" name="submit" value="register" class="btn btn-primary">Register</button>
				<button class="btn btn-primary" type="reset">Reset</button>
			</div>
		</div>
		<a href="<%=request.getContextPath()%>/login.jsp">Back to Login</a>
	</fieldset>
	</form>
	
</div><br><br>

<footer class="container-fluid text-center">
<%@ include file="templates/template-footer.jsp"%>
</footer>

</body>
</html>