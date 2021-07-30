package project1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
public class Query {
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
			ResultSet resultSet = null;
			String sqlQuery = "";
			String outputString= "";
			sqlQuery = "SELECT snum, ssn FROM students WHERE name = 'Becky'";
			stmt = connect.prepareStatement(sqlQuery);
			resultSet = stmt.executeQuery(sqlQuery);
			while(resultSet.next())
			{
				outputString +=  " Snum: " + resultSet.getInt("snum") ;
				outputString += " SSN: " + resultSet.getInt("ssn") + " ";
				
			}
			
			System.out.println(outputString);
			
			sqlQuery = "";
			outputString= "";
			sqlQuery = "SELECT name, level FROM major WHERE snum IN (SELECT snum FROM students WHERE ssn = 123097834)";
			stmt = connect.prepareStatement(sqlQuery);
			resultSet = stmt.executeQuery(sqlQuery);
			while(resultSet.next())
			{
				outputString +=  " name: " + resultSet.getString("name");
				outputString += " level: " + resultSet.getString("level") ;
				
			}
			
			System.out.println(outputString);
			
			sqlQuery = "";
			outputString= "";
			sqlQuery = "select distinct c.name from courses c, departments d where c.department_code = d.code and d.name = 'Computer Science'";
			stmt = connect.prepareStatement(sqlQuery);
			resultSet = stmt.executeQuery(sqlQuery);
			while(resultSet.next())
			{
				outputString +=  " Course Name: " + resultSet.getString("name");
				
				
			}
			
			System.out.println(outputString);
			
			
			
			sqlQuery = "";
			outputString= "";
			sqlQuery = "select distinct g.name, g.level from degrees g, departments d where g.department_code = d.code and d.name = 'Computer Science'";
			stmt = connect.prepareStatement(sqlQuery);
			resultSet = stmt.executeQuery(sqlQuery);
			while(resultSet.next())
			{
				outputString +=  " Name: " + resultSet.getString("name");
				outputString += " level: " + resultSet.getString("level") ;
				
			}
			
			System.out.println(outputString);
			
			
			//
		
			sqlQuery = "";
			outputString= "";
			sqlQuery = "select distinct s.name from students s, minor m where s.snum = m.snum";
			stmt = connect.prepareStatement(sqlQuery);
			resultSet = stmt.executeQuery(sqlQuery);
			while(resultSet.next())
			{
				outputString +=  " Name: " + resultSet.getString("name");
				
				
			}
			
			System.out.println(outputString);
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
