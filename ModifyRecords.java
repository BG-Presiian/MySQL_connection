package project1;
import java.sql.*;
public class ModifyRecords {
	private static Connection connect = null;
	public static void main(String[] args)
	{
		try {
			String userName="coms363";
			String password = "password";
			String dbServer = "jdbc:mysql://localhost:3306/project1";
			
			connect = DriverManager.getConnection(dbServer,userName,password);
		}catch(Exception e) {
			
		}
		Statement stmt = null;
		try {
			stmt = connect.createStatement();
			String modify = "update students set name = 'Scott' where ssn = 746897816";
			stmt.executeUpdate(modify);
			
			
			modify = "update major set name = 'Computer Science', level = 'MS' where snum in (select snum from students where ssn = 746897816)";
			stmt.executeUpdate(modify);
			
			modify = "update major set name = 'Computer Science', level = 'MS' where snum in (select snum from students where ssn = 746897816)";
			stmt.executeUpdate(modify);
			
			modify = "delete from register where regtime = 'Spring2021'";
			stmt.executeUpdate(modify);
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	
		
		try {
			stmt.executeBatch();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(stmt!=null)
				{
					stmt.close();
				}
				if(connect!=null)
				{
					connect.close();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
