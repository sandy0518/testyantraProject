package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class InsertdatIntoDB {
	@Test
	public void insertData() throws SQLException {
		Connection con = null;
		try {
			//Step 1 :- Register the Driver
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			//Step 2 :- Connect to Database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			//step 3 :- Create Statement
			Statement stmt = con.createStatement();
			//Step 4 :- Execute query
			int result = stmt.executeUpdate("insert into student_info (regno, firstrname, middlename, lastname) values(5,'nam','pallava','h');");
			if(result==1) {
				System.out.println("Data is Stored");
			}
			else {
				System.out.println("Data is not stored");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			//		e.printStackTrace();
			System.out.println("Exception Handled");
		}
		finally {
			//Step 5 :- Close Connection with Database
			con.close();
			System.out.println("Connection closed");
		}
	}
}
