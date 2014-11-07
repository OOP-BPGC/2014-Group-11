import java.util.* ;
import java.io.* ; 
import java.nio.file.*; 
import java.sql.* ; 
	/* This class will provide all the database related functionality. */ 
	/* The database file of events will be made in the Events/ folder. */ 
class Utility
{
	/* To be tested.*/ 
	public boolean loginCorrect(String username, String password)
	{
		/* Check login details...*/ 
		return true ;
	}
	public void writeEvent(Event ev)
	{
		/* Write to database here. */ 
	}
	public void listTShirts() throws SQLException
	{
		
		ResultSet rs = Application.stmt.executeQuery(" SELECT name FROM sqlite_master WHERE type = \"table\" ") ; 
		while(rs.next() == true)
		{
			System.out.println(rs.getString(1)) ; 
		}
		rs.close() ; 
	}
}
	
