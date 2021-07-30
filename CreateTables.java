package project1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
public class CreateTables {
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
			stmt.addBatch("CREATE TABLE IF NOT EXISTS students(\r\n" + 
			"	snum INT,\r\n" +
			"	ssn INTEGER,\r\n" +
			"	name VARCHAR(10),\r\n" +
			"	gender VARCHAR(1),\r\n" +
			"	dob DATE,\r\n" +
			"	c_addr VARCHAR(20),\r\n" +
			"	c_phone VARCHAR(10),\r\n" +
			"	p_addr VARCHAR(20),\r\n" +
			"	p_phone VARCHAR(10),\r\n" +
			"	PRIMARY KEY(ssn),\r\n" +
			"	UNIQUE(snum)\r\n" +
			"	);");
			String departments= "CREATE TABLE IF NOT EXISTS departments (" +
					"	code int NOT NULL, " +
					"	name VARCHAR(50) NOT NULL UNIQUE," +
					"	phone VARCHAR(10)," +
					"	college VARCHAR(20)," +
					"	PRIMARY KEY (code)" +
					")";
			stmt.addBatch(departments);
			
			String degrees="CREATE TABLE IF NOT EXISTS degrees (" +
					"	name varchar(50) NOT NULL, " +
					"	 level varchar(5) NOT NULL," +
					"	 department_code int," +
					"	FOREIGN KEY (department_code) REFERENCES departments(code) ON UPDATE CASCADE ON DELETE CASCADE," +
					"	PRIMARY KEY (name, level)" +
					")";
			stmt.addBatch(degrees);
			
			String courses="CREATE TABLE IF NOT EXISTS courses (" +
					"	number int NOT NULL," +
					"	 name varchar(50) NOT NULL UNIQUE," +
					"	 descrption varchar(50)," +
					"	credithours int," +
					"	level varchar(20)," +
					"	 department_code int," +
					"	FOREIGN KEY (department_code) REFERENCES departments(code) ON UPDATE CASCADE ON DELETE CASCADE," +
					"		PRIMARY KEY (number)" +
					")";
			stmt.addBatch(courses);
			
			String major="CREATE TABLE IF NOT EXISTS major (" +
					"	 snum int NOT NULL," +
					"	 name varchar(50) NOT NULL," +
					"	  level varchar(5) NOT NULL," +
					"	FOREIGN KEY (snum) REFERENCES students(snum) ON UPDATE CASCADE ON DELETE CASCADE," +
					"	FOREIGN KEY (name, level) REFERENCES degrees(name, level) ON UPDATE CASCADE ON DELETE CASCADE," +
					"	PRIMARY KEY(snum, name, level)" +
					")";
			stmt.addBatch(major);
			
			String minor="CREATE TABLE IF NOT EXISTS minor (" +
					"	 snum int NOT NULL," +
					"	 name varchar(50) NOT NULL," +
					"	  level varchar(5) NOT NULL," +
					"	 FOREIGN KEY (snum) REFERENCES students(snum) ON UPDATE CASCADE ON DELETE CASCADE," +
					"	FOREIGN KEY (name, level) REFERENCES degrees(name, level) ON UPDATE CASCADE ON DELETE CASCADE," +
					"	PRIMARY KEY(snum, name, level)" +
					")";
			stmt.addBatch(minor);
			
			String register="CREATE TABLE IF NOT EXISTS register (" +
					"	 snum int NOT NULL," +
					"	  course_number int NOT NULL," +
					"	   regtime varchar(20)," +
					"	  grade int," +
					"	FOREIGN KEY (snum) REFERENCES students(snum) ON UPDATE CASCADE ON DELETE CASCADE," +
					"	FOREIGN KEY (course_number) REFERENCES courses(number) ON UPDATE CASCADE ON DELETE CASCADE," +
					"	PRIMARY KEY(snum, course_number)" +
					")";
			stmt.addBatch(register);
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
