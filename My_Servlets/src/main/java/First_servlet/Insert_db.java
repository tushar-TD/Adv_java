package First_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;


@WebServlet("/Insert_db")

public class Insert_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con=null;
    public Insert_db() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url1="jdbc:mysql://localhost:3306/input";
			con=DriverManager.getConnection(url1,"root","root");
			System.out.println("Established!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String pswd=request.getParameter("pswd");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String cno=request.getParameter("cno");
		String m_id=request.getParameter("m_id");
		
		PreparedStatement ps=null;
		
		
		try {
			ps=con.prepareStatement("insert into inptable values (?,?,?,?,?,?)");
			
			ps.setString(1, uid);
			ps.setString(2, pswd);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, m_id);
			ps.setString(6, cno);
			
			int n =ps.executeUpdate();
			if(n>0)
				out.write("Successfully Registred ");
			else
				out.write("ops! Registration Failed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
