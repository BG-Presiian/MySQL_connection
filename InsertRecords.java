package project1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
public class InsertRecords {
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
			String studentsInsert = "INSERT INTO students " + "VALUES (1001, 654651234, 'Randy', 'M', '2000-12-01', '301 E Hall', '5152700988', '121 Main', '7083066321')" + " ON DUPLICATE KEY UPDATE snum=snum ";
			stmt.executeUpdate(studentsInsert);
			studentsInsert = "INSERT INTO students " + "VALUES (1002, 123097834, 'Victor', 'M', '2000-05-06', '270 W Hall', '5151234578', '702 Walnut', '7080366333')"+ " ON DUPLICATE KEY UPDATE snum=snum ";
			stmt.executeUpdate(studentsInsert);
			studentsInsert = "INSERT INTO students " + "VALUES (1003, 978012431, 'John', 'M', '1999-07-08', '201 W Hall', '5154132805', '888 University', '5152012011')"+ " ON DUPLICATE KEY UPDATE snum=snum ";
			stmt.executeUpdate(studentsInsert);
			studentsInsert = "INSERT INTO students " + "VALUES (1004, 746897816, 'Seth', 'M', '1998-12-30', '199 N Hall', '5158891504', '21 Green', '5154132907')"+ " ON DUPLICATE KEY UPDATE snum=snum ";
			stmt.executeUpdate(studentsInsert);
			studentsInsert = "INSERT INTO students " + "VALUES (1005, 186032894, 'Nicole', 'F', '2001-04-01', '178 S Hall', '5158891155', '13 Gray', '5157162071')"+ " ON DUPLICATE KEY UPDATE snum=snum ";
			stmt.executeUpdate(studentsInsert);
			studentsInsert = "INSERT INTO students " + "VALUES (1006, 534218752, 'Becky', 'F', '2001-05-16', '12 N Hall', '5157083698', '189 Clark', '2034367632')"+ " ON DUPLICATE KEY UPDATE snum=snum ";
			stmt.executeUpdate(studentsInsert);
			studentsInsert = "INSERT INTO students " + "VALUES (1007, 432609519, 'Kevin', 'M', '2000-08-12', '75 E Hall', '5157082497', '89 National', '7182340772')"+ " ON DUPLICATE KEY UPDATE snum=snum ";
			stmt.executeUpdate(studentsInsert);
			
			String departmentsInsert = "INSERT INTO departments " + "VALUES (401, 'Computer Science', '5152982801', 'LAS')" + " ON DUPLICATE KEY UPDATE code=code ";
			stmt.executeUpdate(departmentsInsert);
			departmentsInsert = "INSERT INTO departments " + "VALUES (402, 'Mathematics', '5152982802', 'LAS')"+ " ON DUPLICATE KEY UPDATE code=code ";
			stmt.executeUpdate(departmentsInsert);
			departmentsInsert = "INSERT INTO departments " + "VALUES (403, 'Chemical Engineering', '5152982803', 'Engineering') " + " ON DUPLICATE KEY UPDATE code=code ";
			stmt.executeUpdate(departmentsInsert);
			departmentsInsert = "INSERT INTO departments " + "VALUES (404, 'Landscape Architect', '5152982804', 'Design') "+ " ON DUPLICATE KEY UPDATE code=code ";
			stmt.executeUpdate(departmentsInsert);
			
			String degreesInsert = "INSERT INTO degrees " + "VALUES ('Computer Science', 'BS', 401)" + " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(degreesInsert);
			degreesInsert = "INSERT INTO degrees " + "VALUES ('Software Engineering', 'BS', 401)"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(degreesInsert);
			degreesInsert = "INSERT INTO degrees " + "VALUES ('Computer Science', 'MS', 401) " + " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(degreesInsert);
			degreesInsert = "INSERT INTO degrees " + "VALUES ('Computer Science', 'PhD', 401) "+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(degreesInsert);
			degreesInsert = "INSERT INTO degrees " + "VALUES ('Applied Mathematics', 'MS', 402) "+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(degreesInsert);
			degreesInsert = "INSERT INTO degrees " + "VALUES ('Chemical Engineering', 'BS', 403) "+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(degreesInsert);
			degreesInsert = "INSERT INTO degrees " + "VALUES ('Landscape Architect', 'BS', 404) "+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(degreesInsert);
			
			String majorInsert = "INSERT INTO major " + "VALUES (1001, 'Computer Science', 'BS')" + " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(majorInsert);
			majorInsert = "INSERT INTO major " + "VALUES (1002, 'Software Engineering', 'BS')"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(majorInsert);
			majorInsert = "INSERT INTO major " + "VALUES (1003, 'Chemical Engineering', 'BS') " + " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(majorInsert);
			majorInsert = "INSERT INTO major " + "VALUES (1004, 'Landscape Architect', 'BS')"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(majorInsert);
			majorInsert = "INSERT INTO major " + "VALUES (1005, 'Computer Science', 'MS')" + " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(majorInsert);
			majorInsert = "INSERT INTO major " + "VALUES (1006, 'Applied Mathematics', 'MS')"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(majorInsert);
			majorInsert = "INSERT INTO major " + "VALUES (1007, 'Computer Science', 'PhD') " + " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(majorInsert);
			
			
			String minorInsert = "INSERT INTO minor " + "VALUES (1007, 'Applied Mathematics', 'MS')" + " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(minorInsert);
			minorInsert = "INSERT INTO minor " + "VALUES (1005, 'Applied Mathematics', 'MS')"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(minorInsert);
			minorInsert = "INSERT INTO minor " + "VALUES (1001, 'Software Engineering', 'BS')"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(minorInsert);
			
			String coursesInsert = "INSERT INTO courses " + "VALUES (113, 'Spreadsheet', 'Microsoft Excel and Access', 3, 'Undergraduate', 401)" + " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(coursesInsert);
			coursesInsert = "INSERT INTO courses " + "VALUES (311, 'Algorithm', 'Design and Analysis', 3, 'Undergraduate', 401)"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(coursesInsert);
			coursesInsert = "INSERT INTO courses " + "VALUES (531, 'Theory of Computation', 'Theorem and Probability', 3, 'Graduate', 401)"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(coursesInsert);
			coursesInsert = "INSERT INTO courses " + "VALUES (363, 'Database', 'Design Principle', 3, 'Undergraduate', 401)"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(coursesInsert);
			coursesInsert = "INSERT INTO courses " + "VALUES (412, 'Water Management', 'Water Management', 3, 'Undergraduate', 404)"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(coursesInsert);
			coursesInsert = "INSERT INTO courses " + "VALUES (228, 'Special Topics', 'Interesting Topics about CE', 3, 'Undergraduate', 403)"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(coursesInsert);
			coursesInsert = "INSERT INTO courses " + "VALUES (101, 'Calculus', 'Limit and Derivative', 4, 'Undergraduate', 402)"+ " ON DUPLICATE KEY UPDATE level=level ";
			stmt.executeUpdate(coursesInsert);
			
			String registerInsert = "INSERT INTO register " + "VALUES  (1001, 363, 'Fall2020', 3)" + " ON DUPLICATE KEY UPDATE grade=grade ";
			stmt.executeUpdate(registerInsert);
			registerInsert = "INSERT INTO register " + "VALUES (1002, 311, 'Fall2020', 4)"+ " ON DUPLICATE KEY UPDATE grade=grade ";
			stmt.executeUpdate(registerInsert);
			registerInsert = "INSERT INTO register " + "VALUES (1003, 228, 'Fall2020', 4)"+ " ON DUPLICATE KEY UPDATE grade=grade ";
			stmt.executeUpdate(registerInsert);
			registerInsert = "INSERT INTO register " + "VALUES (1004, 363, 'Spring2021', 3)"+ " ON DUPLICATE KEY UPDATE grade=grade ";
			stmt.executeUpdate(registerInsert);
			registerInsert = "INSERT INTO register " + "VALUES (1005, 531, 'Spring2021', 4)"+ " ON DUPLICATE KEY UPDATE grade=grade ";
			stmt.executeUpdate(registerInsert);
			registerInsert = "INSERT INTO register " + "VALUES (1006, 363, 'Fall2020', 3)"+ " ON DUPLICATE KEY UPDATE grade=grade ";
			stmt.executeUpdate(registerInsert);
			registerInsert = "INSERT INTO register " + "VALUES (1007, 531, 'Spring2021', 4)"+ " ON DUPLICATE KEY UPDATE grade=grade ";
			stmt.executeUpdate(registerInsert);
			
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