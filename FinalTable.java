import java.sql.*;
import java.io.*;
import java.util.*;

public class FinalTable extends Exception {
	
	static final String dburl = "jdbc:mysql://localhost:3306/studentdatabase";
	static final String user = "root";
	static final String pass = "Sai971999*";
	

	public static void main(String[] args) {
		
		//Connection to the database
		try {
			Connection mycon = DriverManager.getConnection(dburl, user, pass);
			Statement mystat = mycon.createStatement();
			
			
			
		//Main part to insert the file
			
			
			FileInputStream ins = new FileInputStream("C:\\Users\\sai.muralidharan\\Downloads\\POC-DBData\\input.txt");
			DataInputStream dat = new DataInputStream(ins);
			BufferedReader br = new BufferedReader(new InputStreamReader(dat));
			String lyn ;
			ArrayList list = new ArrayList();
			while((lyn = br.readLine()) != null) {
				list.add(lyn);
				
			}
			Iterator it;
            for (it = list.iterator(); it.hasNext(); ) {
                String str = it.next().toString();
                
                String[] splitt = str.split("\t");
                String sid = "", fisname = "", lasname = "", deptID = "", joinDate = "", dob = "", mobno = "", emailID = "";
                
                for (int i = 0; i <= 8; i++) {
                    sid = splitt[0];
                    fisname = splitt[1];
                    lasname = splitt[2];
                    deptID = splitt[3];
                    joinDate = splitt[4];
                    dob = splitt[5];
                    mobno = splitt[6];
                    emailID = splitt[7];
                }
		
                ResultSet rsSet = null;
                Statement Stmnt = mycon.createStatement();

                rsSet = Stmnt.executeQuery("select * from ClgDepartment");
                
                while(rsSet.next())
                {
                    if(deptID.equals(rsSet.getString("Department")))
                    {
                        deptID=new String(rsSet.getString("DepartmentID"));
                    }
                }
                int k = Stmnt.executeUpdate("insert into Student_table(StudentID, First_Name, Last_Name, DepartmentID, Joining_Date, DOB, Mobile_No, EmailID) values('" + sid + "','" + fisname + "','" + lasname + "','" + deptID + "','" + joinDate + "','"+ dob +"','"+ mobno+"','"+ emailID+"')");
                
                System.out.println("inserted "+fisname+" into database ");
            }
		} catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

	}

}
