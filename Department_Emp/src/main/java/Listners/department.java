package Listners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class department implements ServletContextListener {
    Connection con;
	public department() {
        // TODO Auto-generated constructor stub
    }
	
	public void contextDestroyed(ServletContextEvent s)
	{
		try 
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void contextInitialized(ServletContextEvent s) 
	{
		String url=s.getServletContext().getInitParameter("jdbcurl");
		String user=s.getServletContext().getInitParameter("root");
		String pwd=s.getServletContext().getInitParameter("root");
		String driver=s.getServletContext().getInitParameter("driverclass");
	try 
	{
		Class.forName(driver);
		con=DriverManager.getConnection(url, user, pwd);
		s.getServletContext().setAttribute("jdbccon",con);
		System.out.println("Connection is set as Context level");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
}
