<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="domain.bean.Book"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<title>Search Result</title>
<head>
  <%@ include file="templates/template-meta.jsp"%>
</head>
<body>

<%@ include file="templates/template-header.jsp"%>

<%@ include file="templates/template-navbar.jsp"%>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Title</th>
      <th scope="col">Ed.</th>
      <th scope="col">Author</th>
      <th scope="col">Subject</th>
      <th scope="col">ISBN</th>
      <th scope="col">Avl.</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <%
				List<Book> bookList = (List<Book>)request.getAttribute("bookList");
					if(bookList != null && bookList.size() > 0){
						for(Book book : bookList){
			%>
						<tr>
							<td><a href = "<%=request.getContextPath()%>/BookInfoController?title=<%= book.getTitle() %>&edition=<%= book.getEdition() %>&authors=<%= book.getAuthors() %>&subject=<%= book.getSubject() %>&isbn=<%= book.getISBN() %>"><%= book.getTitle() %></a></td>
							<td><%= book.getEdition() %></td>
							<td><%= book.getAuthors() %></td>
							<%--<td><img src="<%=book.getPic() %>"/></td>--%>
							<td><%= book.getSubject() %></td>
							<td><%= book.getISBN() %></td>
							<td><%= book.getAvailability() %></td>
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
<%@ include file="templates/template-footer.jsp"%>
</footer>

</body>
</html>




