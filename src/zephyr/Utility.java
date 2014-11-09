import java.util.* ;
import java.lang.* ; 
import java.io.* ; 
import java.nio.file.*; 
import zephyr.Person ; 
import java.sql.* ; 
/* This class will provide all the database related functionality. */ 
/* The database file of events will be made in the Events/ folder. */ 
class Utility
{
	/* To be tested.*/ 
	public boolean loginCorrect(int username, String password, Statement stmt) throws SQLException 
	{
		if((password == null)||(stmt == null))
		{
			throw new java.lang.NullPointerException("NULL") ; 	
		}
		ResultSet rs = stmt.executeQuery("SELECT * FROM Person WHERE id = " + username) ; 
		while(rs.next() == true)
		{
			if(rs.getString("password").equals(password)) 
				return true ; 
		}
		return false ;
	}

	public static ArrayList<Person>  listAllParticipants()
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

