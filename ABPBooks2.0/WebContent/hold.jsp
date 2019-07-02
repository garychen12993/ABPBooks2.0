<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<title>List</title>
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
        <li class="active"><a href="<%=request.getContextPath()%>/HoldController?action=display"><span class="glyphicon glyphicon-list-alt"></span> List</a></li>
        <li><a href="loans.jsp"><span class="glyphicon glyphicon-book"></span> Loans</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
      </ul>
    </div>
  </div>
</nav>
${message}<br>
<%@ page import="java.util.*" %>
<%@ page import="domain.bean.*" %>
<%                    
			if (username == null) {
        %>
            Please sign in.
        <% }
		else {
         %>
            <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">ABPID</th>
      <th scope="col">Title</th>
      <th scope="col">Edition</th>
      <th scope="col">Authors</th>
      <th scope="col">ISBN</th>
      <th scope="col">Hold position</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <%
      			List<HoldItem> holdList = (List) request.getAttribute("holdList");
					if(holdList != null && holdList.size() > 0){
						for(HoldItem holdItem : holdList){
			%>
						<tr>
							<td><%= holdItem.getABPID() %></td>
							<td><%= holdItem.getTitle() %></td>
							<td><%= holdItem.getEdition() %></td>
							<td><%= holdItem.getAuthors() %></td>
							<td><%= holdItem.getISBN() %></td>
							<td><%= holdItem.getQueue() %></td>
							<td></td>
							<td></td>
							<td>
								<form action="<%=request.getContextPath()%>/HoldController" method="post">
									<input type="hidden" name="action" id="action" value ="remove">
    								<input type="hidden" name="ABPID" id="ABPID" value = <%= holdItem.getABPID() %>>
    								<input type="hidden" name="queue" id="queue" value = <%= holdItem.getQueue() %>>
  									<input type="submit" class="btn btn-primary" name="submit" value="Remove"><br>    
								</form>
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
        <% }%>



<footer class="container-fluid text-center">
<%@ include file="templates/template-footer.jsp"%>
</footer>

</body>
</html>