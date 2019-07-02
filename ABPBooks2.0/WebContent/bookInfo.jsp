<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="domain.bean.Book"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<title>Bootstrap Example</title>
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

<% List<Book> bookList = (List<Book>)request.getAttribute("bookList"); %>
<% out.println(bookList.get(0).getTitle()); %> </br>
<% out.println(bookList.get(0).getISBN()); %></br>
<% out.println(bookList.get(0).getAuthors()); %></br>
<% out.println(bookList.get(0).getEdition()); %></br>
<% out.println(bookList.get(0).getSubject()); %></br>
<br>
<br>

<table class="table table-striped" style="margin-bottom: 0;" style="margin-top: 0;">
<thead bgcolor="black">
    <tr>
      <th class="text-center" scope="col" style ="color:white">Copy/Status information</th>
    </tr>
  </thead>
    ${errmessage}<br>
    ${message}<br>
<table class="table table-striped" style="margin-top: 0;">
	<tr>
      <th scope="col">Location</th>
      <th scope="col">ABPID</th>
      <th scope="col">Status</th>
      <th scope="col">Due Date</th>
      <th scope="col"></th>
    </tr>
  <tbody>
    <tr>
      <%
					if(bookList != null && bookList.size() > 0){
						for(Book book : bookList){
			%>
						<tr>
							<td width="10%">HH 2.702</td>
							<td width="10%"><%= book.getABPID() %></td>
							<%--<td><img src="<%=book.getPic() %>"/></td>--%>
							<td width="10%">
							<% if(book.getStatus() == 1) {out.print("Available");}
								else if(book.getStatus() == 2) {out.print("Currently on hold");}
								else if(book.getStatus() == 3) {out.print("Checked out");}%>
							</td>
							<td width="55%"></td>
							<td>
								<form action="<%=request.getContextPath()%>/CartController" method="post">
									<input type="hidden" name="action" id="action" value ="insert">
    								<input type="hidden" name="ABPID" id="ABPID" value = <%= book.getABPID() %>>
    								<input type="hidden" name="title" id="title" value = <%= book.getTitle() %>>
    								<input type="hidden" name="edition" id=""edition"" value = <%= book.getEdition() %>>
    								<input type="hidden" name="author" id="author" value = <%= book.getAuthors() %>>
    								<input type="hidden" name="isbn" id="isbn" value = <%= book.getISBN() %>>
    								<input type="hidden" name="subject" id="subject" value = <%= book.getSubject() %>>
  									<input type="submit" class="btn btn-primary" name="addToCart" value="Add to cart">
  									<input type="submit" class="btn btn-primary" name="placeHold" value="Place hold">
								</form>
								<!--<a>Add to cart</a></br>-->
								<!--<a>Place hold</a>-->
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
  </table>

<br><br>

<footer class="container-fluid text-center">
<%@ include file="templates/template-footer.jsp"%>
</footer>

</body>
</html>




