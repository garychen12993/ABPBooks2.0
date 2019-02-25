<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="domain.bean.Book"%>
<%@page import="java.util.*"%>
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
    .table-striped>tbody>tr:nth-child(odd)>td, .table-striped>tbody>tr:nth-child(odd)>th {
   	  background-color: #dff0d8; // Choose your own color here
 	}
  </style>
</head>
<body>

<div class="jumbotron">
	<div class="container text-center">
		<a href="studentHome.jsp"><img class="responsive" src="ABPLogo.PNG" alt="abpbooks" style="width:200px"></a>
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
<% List<Book> bookList = (List<Book>)request.getAttribute("bookList"); %>
<% out.println(bookList.get(0).getTitle()); %> </br>
<% out.println(bookList.get(0).getISBN()); %></br>
<% out.println(bookList.get(0).getAuthors()); %></br>
<% out.println(bookList.get(0).getEdition()); %></br>
<% out.println(bookList.get(0).getSubject()); %></br>

<table class="table table-striped">

<thead>
    <tr>
      <th scope="col"></th>
      <th scope="col"></th>
      <th scope="col"></th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <thead bgcolor="black">
    <tr>
      <th scope="col"></th>
      <th scope="col"></th>
      <th class="text-center" scope="col" style ="color:white">Copy/Status information</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <thead>
    <tr>
      <th scope="col">Location</th>
      <th scope="col">ABPID</th>
      <th scope="col">Status</th>
      <th scope="col">Due Date</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <%
					if(bookList != null && bookList.size() > 0){
						for(Book book : bookList){
			%>
						<tr>
							<td>HH 2.702</td>
							<td><%= book.getABPID() %></td>
							<%--<td><img src="<%=book.getPic() %>"/></td>--%>
							<td>
							<% if(book.getAvailability() == 1) {out.print("Available");}
								else if(book.getAvailability() == 0) {out.print("Checked Out");}%>
							</td>
							<td></td>
							<td>
								<a>Add to cart</a></br>
								<a>Place hold</a>
							</td>
							<%--<td>
								<a href="<%=request.getContextPath()%>/admin/AdEditDishController?id=<%=book.getId()%>">edit</a>
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/admin/AdDeleteDishController?id=<%=book.getId()%>" onclick="javascript:return del();">delete</a>
							</td>--%>
						</tr>
						<%
					}
				}
				
			%>
    </tr>
  </tbody>
</table>

<br><br>

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




