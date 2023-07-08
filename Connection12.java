package jdbc1;
import java.sql.*;
public class Connection12 {

	public static void main(String[] args) throws Exception{
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
		rs.close();
		stmt.close();
		con.close();
	}

}
