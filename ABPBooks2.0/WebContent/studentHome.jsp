<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<title>Search</title>
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
        <li class="active"><a href="studentHome.jsp"><span class="glyphicon glyphicon-search"></span> Search</a></li>
        <li><a href="<%=request.getContextPath()%>/CartController?action=display"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
        <li><a href="<%=request.getContextPath()%>/HoldController?action=display"><span class="glyphicon glyphicon-list-alt"></span> List</a></li>
        <li><a href="loans.jsp"><span class="glyphicon glyphicon-book"></span> Loans</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
	<form class="form-horizontal" action="<%=request.getContextPath()%>/SearchController" method="post">
	<fieldset>
	<legend>Book information:</legend>
		<div class="form-group">
			<label class="control-label col-sm-2" for="title">Title:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="title" placeholder="Enter Book Title" name="title">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="edition">Edition:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="edition" placeholder="Enter Book Edition" name="edition">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="author">Author:</label>
			<div class="col-sm-10">          
				<input type="text" class="form-control" id="author" placeholder="Enter Author" name="author">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="isbn">ISBN:</label>
			<div class="col-sm-10">          
				<input type="number" class="form-control" id="isbn" placeholder="Enter ISBN" name="isbn">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="subject">Subject:</label>
			<div class="col-sm-10">          
				<select class="form-control" id="subject" name="subject">
					<option value="null">Choose a Subject...</option>
					<option value="art">Art</option>
					<option value="business">Business</option>
					<option value="compsci">Computer Science</option>
					<option value="education">Education</option>
					<option value="engineering">Engineering</option>
					<option value="humanities">Humanities</option>
					<option value="math">Math</option>
					<option value="natsci">Natural Sciences</option>
					<option value="socsci">Social Sciences</option>
				</select>
			</div>
		</div>
		
		<div class="form-group">        
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</div>
	</fieldset>
	</form>
	
</div><br><br>

<footer class="container-fluid text-center">
<%@ include file="templates/template-footer.jsp"%>
</footer>

</body>
</html>
