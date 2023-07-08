package Listners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ShoppingAppListners implements ServletContextListener {

	Connection con;
	public void contextDestroyed(ServletContextEvent sce)
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
	
   

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	String url=sce.getServletContext().getInitParameter("jdbcurl");
    	String driver=sce.getServletContext().getInitParameter("diverclass");
    	
    	String user=sce.getServletContext().getInitParameter("user");
    	String pwd=sce.getServletContext().getInitParameter("password");    	
    try 
    	{
    		Class.forName(driver);
    		con=DriverManager.getConnection(url,user,pwd);
    		sce.getServletContext().setAttribute("jdbccon", con);
    		System.out.println("Connection is set as context level.");
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
	
}
