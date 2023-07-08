//package Logic;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.util.*;
//
//@WebServlet("/viewcart")
//public class viewcart extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	Connection con;
//	
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		super.init(config);
//		con=(Connection)config.getServletContext().getAttribute("jdbccon");
//	}
//
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		PrintWriter out=response.getWriter();
//		HttpSession session=request.getSession();
//		List<Integer> sps=(List<Integer>)session.getAttribute("cart");
//		if(sps==null)
//		{
//			out.println("<p>No product are selected</p>");
//		}
//		else
//		{
//			for(int n:sps)
//				out.println("<li>"+n+"</li>");
//			out.println("<ul>");
//			out.println("<table border=1>");
//			PreparedStatement ps=null;
//			ResultSet rs=null;
//			try 
//			{
//				ps = con.prepareStatement("select * from product where p_id = ?");
//				int cnt=0;
//				float tprice=0;
//				for( int n : sps)
//				{
//					ps.setInt(1, n);
//					rs = ps.executeQuery();
//					if(rs.next())
//					{
//						out.println("<tr>");
//						out.print("<td>"+ (++cnt) + "</td>");
//						out.print("<td>"+ rs.getString(2) + "</td>");
//						out.print("<td>"+ rs.getString(4) + "</td>");
//						out.print("<td> <a href='deleteItem?pid="+ rs.getInt(1)+"'> delete </a>  </td>");
//						out.println("</tr>");
//						tprice+=Float.parseFloat(rs.getString(4));
//					}
//					
//				}
//				session.setAttribute("tprice", tprice);
//				out.println("<tr>");
//				out.print("<td colspan='2'> Total price </td>");
//				out.print("<td>"+ tprice + "</td>");
//				out.println("</tr>");
//				out.println("</table>");
//				out.print("<br/> <br/> <a href='confirmcart'> Confirm Cart <a/>");
//				out.print("<br/> <br/> <a href='home'> Go back to Categories <a/>");
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//			finally
//			{
//				try
//				{
//					rs.close();
//					ps.close();					
//				}
//				catch(Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
