import java.sql.*;

public class ClgDepartment {
	
	static final String dburl = "jdbc:mysql://localhost:3306/studentdatabase";
	static final String user = "root";
	static final String pass = "Sai971999*";
	

	public static void main(String[] args) {
		
		try {
			Connection mycon = DriverManager.getConnection(dburl, user, pass);
			Statement mystat = mycon.createStatement();
			
		//closing a table if already present.
			
			String close = "DROP TABLE IF EXISTS clgdepartment";
			mystat.executeUpdate(close);
			
		//creating a table for our need. 
			
			String tab = "CREATE TABLE ClgDepartment" + "(DepartmentID INTEGER ," + "Department VARCHAR(255) ," + "PRIMARY KEY (DepartmentID))";
			mystat.executeUpdate(tab);
			System.out.println("Department table has been created in the database....");
			
		// Inserting values to the created table.
			System.out.println("Inserting the datas into the table....");
			tab = "INSERT INTO ClgDepartment VALUE(1001, 'CSE');";
			mystat.executeUpdate(tab);
			tab = "INSERT INTO ClgDepartment VALUE(1002, 'EEE');";
			mystat.executeUpdate(tab);
			tab = "INSERT INTO ClgDepartment VALUE(1003, 'IT');";
			mystat.executeUpdate(tab);
			tab = "INSERT INTO ClgDepartment VALUE(1004, 'ECE');";
			mystat.executeUpdate(tab);
			tab = "INSERT INTO ClgDepartment VALUE(1005, 'ARCH');";
			mystat.executeUpdate(tab);
			tab = "INSERT INTO ClgDepartment VALUE(1006, 'MECH');";
			mystat.executeUpdate(tab);
			
			System.out.println("The Datas has been insterted in the table....");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
