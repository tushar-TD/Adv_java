<%@ page import="java.util.*,java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection con=null;
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
		RequestDispatcher rd = request.getRequestDispatcher("/header");
		rd.include(request, response);
		response.setContentType("text/html");
		List<Integer> sps=(List<Integer>)session.getAttribute("cart");
		if(sps==null)
		{%>
			<%= "<p>Product Not Selected</p>" %>
		<%}
		else
		{%>
			<%= "<table border='1'>" %>
			<%= "<th>Sr.No</th> "%>
			<%= "<th>P.Name</th>" %>
			<%= "<th>Price</th>" %>
			<% PreparedStatement ps=con.prepareStatement("select * from product where p_id = ?");
				int cnt=0;
				float tprice=0;
				for(int n:sps)
				{
					ps.setInt(1, n);
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{ %>
						<%= "<tr>" %>
						<%= "<td>"+(++cnt)+"</td>" %>
						<%= "<td>"+rs.getString(2)+"</td>" %>
						<%= "<td>"+rs.getString(4)+"</td>" %>
						<%= "<td><a href='deleteItem?pid="+rs.getInt(1)+"'>delete</a></td>" %>
						<% tprice+=Float.parseFloat(rs.getString(4)) ;%>
						<%= "</tr>" %>
					<% }			
				}
				session.setAttribute("tprice", tprice);%>
				<%= "<tr>" %>
				<%= "<td colspan='2'>Total Price</td>" %>
				<%= "<td>"+tprice+"</td>" %>
				<%= "</tr>" %>
				<%= "</table>" %>
				
				<%= "<br/><a href='confirmcart'> Confirm Cart <a/>" %>
				<%= "<br/><br/><a href='home'> Go back to Categories <a/>" %>
				<%= "<br/><br/><a href='logout'> Logout <a/>" %>
			
			
		
	<% }%>
	
</body>
</html>