<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="domain.bean.Book"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function del() {
	var msg = "Are you sure to delete this dish？\n\nPlease Confirm！";
	if (confirm(msg)==true) { return true; }
	else { return false; }
}
</script>
</head>
<body>
<div>
	<div float='left' width='20%' background-color='red'">
		<a href="<%=request.getContextPath()%>/admin/AdAddDishController">add dish</a><br/>
		<a href="<%=request.getContextPath()%>/admin/showOrder">show order</a>
	</div>
	<div float='right' width='60%'>
		<table border='1' cellspacing='0' width='60%'>
			<tr>
				<td>Title</td>
				<td>Ed.</td>
				<td>Author</td>
				<td>Subject</td>
				<td>ISBN</td>
				<td>Avl.</td>
				<%--<td>Edit_Dish</td>
				<td>Delete_Dish</td>--%>
			</tr>
			<tr>
			<%
				List<Book> bookList = (List<Book>)request.getAttribute("bookList");
					if(bookList != null && bookList.size() > 0){
						for(Book book : bookList){
			%>
						<tr>
							<td><%= book.getTitle() %></td>
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
		</table>
		<!-- <button>test</button> -->
	</div>
</div>
</body>
</html>