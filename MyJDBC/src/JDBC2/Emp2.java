package JDBC2;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Emp2 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcurl="jdbc:mysql://localhost:3306/dac";
		Connection con=DriverManager.getConnection(jdbcurl,"root","root");
		System.out.println("Connection established");
		
		PreparedStatement ps=con.prepareStatement("select * from emp where SAL between ? and ?");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the minimum salary");
		int min=Integer.parseInt(br.readLine());
		
		System.out.println("Enter the Maximum salary");
		int max=Integer.parseInt(br.readLine());
		
		ps.setFloat(1, min);
		ps.setInt(2, max);
		
		System.out.println("minimum "+min);
	}

}
