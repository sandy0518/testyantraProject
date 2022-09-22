package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ConnectingToDB {
	@Test
	public void readdataFromDataBase() throws SQLException {
		//Step 1 :- Register the Driver
		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
		//Step 2 :- Connect to Database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		//step 3 :- Create Statement
		Statement stmt = con.createStatement();
		//Step 4 :- Execute query
		ResultSet result = stmt.executeQuery("select * from student_info;");
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		}
		//Step 5 :- Close Connection with Database
		con.close();
	}
}
