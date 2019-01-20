<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Center image and able to scale down image, but won't scale up larger than original */
    .responsive {
    	display: block;
		margin-left: auto;
		margin-right: auto;
		max-width: 100%;
		height: auto;
	}
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>

<div class="jumbotron">
	<div class="container text-center">
		<a href="home.jsp"><img class="responsive" src="ABPLogo.PNG" alt="abpbooks" style="width:200px"></a>
	</div>
</div>

<%--<div class="jumbotron">
  <div class="container text-center">
  	<a href="home.jsp"><img class="responsive" src="ABPLogo.PNG" alt="abpbooks" style="width:200px"></a>
    <h1>ABP Books</h1>      
    <p>ABP's Online Library</p>
  </div>
</div>--%>

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
        <li class="active"><a href="home.jsp"><span class="glyphicon glyphicon-search"></span> Search</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-list-alt"></span> List</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-book"></span> Loans</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
	<form class="form-horizontal" action="/action_page.php">
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
					<option value="socsci">SocialSciences</option>
				</select>
			</div>
		</div>
		
		<div class="form-group">        
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</fieldset>
	</form>
	
</div><br><br>

<footer class="container-fluid text-center">
	<p>
	Academic Bridge Program <br>
	800 W. Campbell Road, HH 2.702 <br>
	Richardson, Texas 75080-3021
	</p>
  <%--<form class="form-inline">Get deals:
    <input type="email" class="form-control" size="50" placeholder="Email Address">
    <button type="button" class="btn btn-danger">Sign Up</button>
  </form>--%>
</footer>

</body>
</html>
