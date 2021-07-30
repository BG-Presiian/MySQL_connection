package project1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
public class DropTables {
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
			//Query to drop a table
			String query = "Drop Table if exists major";
			//Executing the query
			stmt.execute(query);
			
			query = "Drop table if exists minor";
			stmt.execute(query);
			
			query = "Drop Table if exists degrees";
			stmt.execute(query);
			
			query = "Drop Table if exists register";
			stmt.execute(query);
			
		    query = "Drop Table if exists courses";
		    stmt.execute(query);
			
			query = "Drop Table if exists students";
			stmt.execute(query);
			
			query = "Drop Table if exists departments";
			stmt.execute(query);
			
			
			
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
