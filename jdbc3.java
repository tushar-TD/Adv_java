package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc3 {

	public static void main(String[] args) throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jurl="jdbc:mysql://localhost:3306/dac";
		Connection con=DriverManager.getConnection(jurl,"root", "root");
		System.out.println("connection done");
		Statement stmt=con.createStatement();
		
		
		ResultSet rs=stmt.executeQuery("select * from emp");
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+" ");
			System.out.print(rs.getString(3)+" ");
			System.out.print(rs.getString(5)+" ");
			System.out.print(rs.getString(7)+" ");
			System.out.println();
		}
		
		System.out.println("----------------------------------------------------");
		Statement mt=con.createStatement() ; 
		int rs1=stmt.executeUpdate("update emp set SAL=6500 where MGR=7698");
		System.out.println(rs1+" record updated");
		
		
		rs.close();
		stmt.close();
		con.close();
	}

}
