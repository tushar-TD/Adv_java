package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc5 {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jurl="jdbc:mysql://localhost:3306/dac";
		Connection con=DriverManager.getConnection(jurl,"root", "root");
		System.out.println("connection done");
		Statement stmt=con.createStatement();
		
		
		ResultSet rs=stmt.executeQuery("select d.dname,avg(e.SAL) from dept d,emp e where d.DEPTNO=e.DEPTNO group by d.dname");
		while(rs.next())
		{
			System.out.print(rs.getString(1)+" ");
			System.out.print(rs.getFloat(2)+" ");
			System.out.println();
		}
	}

}
