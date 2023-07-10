package JDBC2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Emp1 {

	
		public static void main(String[] args) throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcUrl="jdbc:mysql://localhost:3306/dac";
			Connection con=DriverManager.getConnection(jdbcUrl,"root","root");
			System.out.println("Connection established");
			
			PreparedStatement ps=con.prepareStatement("select * from emp where EMPNO=? ");
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Employee ID:");
			int empno=Integer.parseInt(br.readLine());
			
			ps.setInt(1, empno); 
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
					System.out.println(rs.getString(2)+" ");
					System.out.println(rs.getString(6)+" ");
			}
				rs.close();
				ps.close();
				con.close();
				br.close();
		

	}

}
