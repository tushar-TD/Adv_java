<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="Scriptless.User" scope="request" />
	<h1> Welcome <jsp:getProperty property="fname" name="user"/>
	<jsp:getProperty property="lname" name="user"/>
	</h1>
	Email : <jsp:getProperty property="email" name="user"/>
	<br/>
	Age : <jsp:getProperty property="age" name="user"/>
	<br/>
	First Name : <jsp:getProperty property="fname" name="user"/>
	<br/>
	Last Name : <jsp:getProperty property="lname" name="user"/>
	<br/>
	Contact : <jsp:getProperty property="contact" name="user"/>
	<br/>
	Address : <jsp:getProperty property="address" name="user"/>
	<br/>  

</body>
</html>