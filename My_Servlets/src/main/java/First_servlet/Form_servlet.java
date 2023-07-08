package First_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Form_servlet")
public class Form_servlet extends HttpServlet {
	Connection con=null;
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		super.init(config);
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcurl="jdbc:mysql://localhost:3306/shoppingdb";
			 con =DriverManager.getConnection(jdbcurl, "root", "root");
			System.out.println("Established");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uid=request.getParameter("userID1");
		String pwd=request.getParameter("pswd");
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("select * from users where u_id=? and password=?");
			
			ps.setString(1,uid);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			if(rs.next())
			{
				if(rs.getString(1).equals(uid) && rs.getString(2).equals(pwd))
				{
					out.print(uid+"<h2>uid+Login Successfull!</h2>");
				}
			}
			else
			{
				out.print(uid+"<h3>Login Failed!</h3>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				rs.close();
				ps.close();
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
