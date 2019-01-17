<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	Welcome to Register<br>
<form name="regform" action="<%=request.getContextPath()%>/RegisterController" method="post" onsubmit="return regValidate()">
	<br>${message}<br>
	
	Id: <input type="text" name="id"> <br>
	<div id="id_error"></div><br>
	
	Password: <input type="password" name="password" id="password"> 
	<br>
	Re-Type Password: <input type="password" name="retry-password" id="retry-password"> 
	<br>
	<div id="password_error"></div><br>
	
	Email: <input type="text" name="email"> <br>
	First name: <input type="text" name="firstname"><br>
	Last name: <input type="text" name="lastname"><br>
	Major: <input type="text" name="major"><br>
	Address: <input type="text" name="address"><br>
	Phone: <input type="text" name="phone"><br>
	Bridge year: <input type="text" name="bridgeyear"><br>
	<br>
	
	<input type="submit" name="submit" value="register" >
	<input type="reset" name="reset"><br>
	<a href="<%=request.getContextPath()%>/login.jsp">Login</a>
	
	</form>

</body>
</html>