package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc4 {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jurl="jdbc:mysql://localhost:3306/dac";
		Connection con=DriverManager.getConnection(jurl,"root", "root");
		System.out.println("connection done");
		Statement stmt=con.createStatement();
		
		
		ResultSet rs=stmt.executeQuery("select * from emp order by SAL desc ");
		while(rs.next())
		{
			System.out.print(rs.getInt(1)+" ");
			System.out.print(rs.getString(3)+" ");
			System.out.print(rs.getString(5)+" ");
			System.out.print(rs.getString(7)+" ");
			System.out.print(rs.getString(6)+" ");
			System.out.println();
		}
	}

}
