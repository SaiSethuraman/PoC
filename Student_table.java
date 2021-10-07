import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Student_table extends Exception {
	
	static final String dburl = "jdbc:mysql://localhost:3306/studentdatabase";
	static final String user = "root";
	static final String pass = "Sai971999*";

	public static void main(String[] args) {
		
		try
		{
			Connection mycon = DriverManager.getConnection(dburl, user, pass);
			Statement mystat = mycon.createStatement();
			
		//deleting already present table
			String close2 = "DROP TABLE IF EXISTS Student_table ";
			mystat.executeUpdate(close2);
			
		//creating the table as we require
			String create = "CREATE TABLE Student_table " + "(studentID INTEGER, " + "First_Name VARCHAR(255), " + "LAST_Name VARCHAR(255), " + "DepartmentID INTEGER, " 
					+ "Joining_Date date, " + "DOB date, " + "Mobile_No bigint, " + "EmailID VARCHAR(255), " + "PRIMARY KEY(studentID))";
					mystat.executeUpdate(create);
			
			
			System.out.println("The student details table is been created in the database....");
			
			System.out.println("Insterting the values to the table....");
			
			
			create = "INSERT INTO Student_table VALUES(03, 'Revanth', 'Chinnu', 1001, '2017-5-9', '1998-10-9', 9874893278, 'revanth@gmail.com')";
			mystat.executeUpdate(create);
			create = "INSERT INTO Student_table VALUES(01, 'Vikesh', 'Vikki', 1001, '2016-10-5', '1997-7-9', 9123673278, 'vikesh.pathipathi@perficient.com')";
			mystat.executeUpdate(create);
			create = "INSERT INTO Student_table VALUES(02, 'Murali', 'Pathipati', 1001, '2016-8-2', '1996-5-4', 7654673278, 'murali@gmail.com')";
			mystat.executeUpdate(create);
			
		// Creating another statement object to execute the joining of the tables
			Statement sta = mycon.createStatement();
			
		//Joining both the tables
			ResultSet rs = sta.executeQuery("select s.studentID, s.First_Name, s.Last_Name, s.Joining_Date, s.DOB, s.Mobile_No, s.EmailID, s.DepartmentID, d.Department\n" 
		+ "from Student_table s\n" + "join CLgDepartment d\n" + "On s.DepartmentID = d.DepartmentID");
			
			while(rs.next()) {
				String studentID = rs.getString("studentID");
				String FirstName = rs.getString("First_Name");
				String LastName = rs.getString("Last_Name");
				String JoiningDate = rs.getString("Joining_Date");
				String DOB = rs.getString("DOB");
				String MobileNo = rs.getString("Mobile_No");
				String EmailID = rs.getString("EmailID");
				String DepartmentID = rs.getString("DepartmentID");
				String DepartmentName = rs.getString("Department");
				
				System.out.format("%10s%10s%10s%15s%15s%20s%20s%20s%20s\n", studentID, FirstName, LastName, JoiningDate, DOB, MobileNo, EmailID, DepartmentID, DepartmentName) ;
			}
			//close the connection
				mycon.close();
			}
				catch (SQLException throwables) {
					throwables.printStackTrace();
			}	catch (Exception e) {
				e.printStackTrace();
			}
			
			
		
		

	}

}
