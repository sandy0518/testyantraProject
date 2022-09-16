package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ConnectingToDBUsingTCBlock {
	@Test
	public void readdataFromDataBase() throws SQLException {
		//Step 2 :- Connect to Database
		Connection con = null;
		try {
			//Step 1 :- Register the Driver
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			//step 3 :- Create Statement
			Statement stmt = con.createStatement();
			//Step 4 :- Execute query
			ResultSet result = stmt.executeQuery("select * from students_info;");
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("Exception Handled");
		}
		finally {
		//Step 5 :- Close Connection with Database
		con.close();
		System.out.println("Connection closed");
		}
	}
}
