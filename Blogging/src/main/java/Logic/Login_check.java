package Logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import some_classes.Users;


import javax.servlet.http.*;

@WebServlet("/logincheck")
public class Login_check extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public void init(ServletConfig config) throws ServletException {
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check login is successful
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		//create and execute query
		PreparedStatement ps = null;
		ResultSet rs= null;
		try
		{
			ps = con.prepareStatement("select * from users where u_id=? and password = ?");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			rs = ps.executeQuery();   
			
			//login is successful
			if(rs.next())   // record pointer - first record
			{
				Users user = new Users(); 
				HttpSession session = request.getSession();
				session.setAttribute("loggedinuser", user);
				Cookie[] allc=request.getCookies();
				if(allc != null)
				{
					for(Cookie c:allc)
					{
						if(c.getName().equals("loginerror"))
						{
							c.setMaxAge(0);
							response.addCookie(c);
						}
					}
				}
				
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/topics");
				rd.forward(request, response);
			}
			else
			{
				//out.print("<h3> Failed login </h3>");
				Cookie c=new Cookie("Login Error","Wrong_UID/PWD");
				response.addCookie(c);
				response.sendRedirect("/Blogging/index.jsp");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}








