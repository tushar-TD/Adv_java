<%@ page import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to JSP</h1>
<br/>
This is template text!
<br/>
<%--This is JSP comment--%>
<%
int n=0;
out.print("Value of n: "+(++n));
%>
<br/>
<%  out.print(Calendar.getInstance().getTime()); %>
	<%= Calendar.getInstance().getTime()  %>
	<br/>
</body>
</html>