<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
</head>
<body>
<div class="jumbotron">
	<div id="user">
		<%
			String username= (String) session.getAttribute("fName");                     
			if (username == null) {
        %>
            <a href="<%=request.getContextPath()%>/login.jsp">Login</a>
        <% }
		else {
         %>
            Hi, <%=username %>  (<a href="<%=request.getContextPath()%>/logout.jsp">Logout</a>)
        <% }%>
	</div>
	<div class="container text-center">
		<a href="studentHome.jsp"><img class="responsive" src="ABPLogo.PNG" alt="abpbooks" style="width:200px"></a>
	</div>
</div>
</body>
</html>