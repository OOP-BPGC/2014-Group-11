package zephyr.util;

import java.util.* ;
import java.io.* ; 
import java.nio.file.*; 
import java.sql.* ; 
<<<<<<< HEAD:Console/Utility.java
/* This class will provide all the database related functionality. */ 
/* The database file of events will be made in the Events/ folder. */ 
class Utility
=======

public class Utility
>>>>>>> 5fe2ecfc3649e7c6863bdae51a4d6dd5ce8b5bf5:src/zephyr/util/Utility.java
{
	/* To be tested.*/ 
	public boolean loginCorrect(int username, String password, Statement stmt) throws SQLException 
	{
		ResultSet rs = stmt.executeQuery("SELECT * FROM Person WHERE id = " + username) ; 
		while(rs.next() == true)
		{
			if(rs.getString("password").equals(password)) 
				return true ; 
		}
		return false ;
	}

	public static void listAllParticipants()
	{
		try
		{
			Connection c = null ; 
			Statement stmt = null ; 
			c = DriverManager.getConnection("jdbc:sqlite:common") ; 
			stmt = c.createStatement() ; 
			ResultSet rs = stmt.executeQuery("SELECT * FROM Person") ; 
			while(rs.next() == true)
			{
				System.out.format("%-20s%-20s%-4s%-5d", rs.getString("fname"), rs.getString("lname"), rs.getString("hostel"), rs.getInt("id")) ; 
				System.out.println() ; 
			}
		}		
		catch(SQLException ex)
		{	
			System.out.println(ex.getMessage()) ;
		}
	}
}

