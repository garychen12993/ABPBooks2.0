<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<title>Cart</title>
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
        <li class="active"><a href="<%=request.getContextPath()%>/CartController?action=display"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
        <li><a href="<%=request.getContextPath()%>/HoldController?action=display"><span class="glyphicon glyphicon-list-alt"></span> List</a></li>
        <li><a href="loans.jsp"><span class="glyphicon glyphicon-book"></span> Loans</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
      </ul>
    </div>
  </div>
</nav>

<%@ page import="java.util.*" %>
<%@ page import="domain.bean.*" %>
<%                    
			if (username == null) {
        %>
            Please sign in.
        <% }
		else {
         %>
<tbody>

<script type="text/javascript">
function checkAll() {
    var checkboxes = document.getElementsByTagName('input');
	 var val = null;
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].type == 'checkbox') {
            if (val === null) val = checkboxes[i].checked;
            checkboxes[i].checked = val;
        }
    }
}
</script>
${message}
<form action="<%=request.getContextPath()%>/CartController" method="post">
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col" width="3%"><input type="checkbox" onClick="checkAll(this)"/></th>
      <th scope="col">ABPID</th>
      <th scope="col">Title</th>
      <th scope="col">Edition</th>
      <th scope="col">Authors</th>
      <th scope="col">ISBN</th>
      <th scope="col">Subject</th>
    </tr>
  </thead>

    <tr>
      <%
      			List<CartItem> cartList = (List) request.getAttribute("cartList");
					if(cartList != null && cartList.size() > 0){
						for(CartItem cartItem : cartList){
			%>
						<tr>
							<td><input type="checkbox" name="checked" value = <%= cartItem.getABPID() %>></td>
							<td width="5%"><%= cartItem.getABPID() %></td>
							<td width="25%"><%= cartItem.getTitle() %></td>
							<td width="10%"><%= cartItem.getEdition() %></td>
							<td width="25%"><%= cartItem.getAuthors() %></td>
							<td width="15%"><%= cartItem.getISBN() %></td>
							<td width="10%"><%= cartItem.getSubject() %></td>

							<td>
									<input type="hidden" name="action" id="action" value ="remove">
    								<input type="hidden" name="ABPID" id="ABPID" value = <%= cartItem.getABPID() %>>
  									<input type="submit" class="btn btn-primary" name="remove" value="Remove"><br>    
								
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

    </table>
    <input type="hidden" name="action" id="action" value ="remove">
    <input type="submit" class="btn btn-primary" name="placeHoldMultiple" value="Place Hold" style="float: right;"><br>
</form> 
</tbody>
  <% }%>
<footer class="container-fluid text-center">
<%@ include file="templates/template-footer.jsp"%>
</footer>

</body>
</html>