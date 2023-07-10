package Servlets;


import java.io.IOException;
import java.io.PrintWriter;




@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<h1> Welcome to servlets </h1>");
		
		
	}

}
