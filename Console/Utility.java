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
	public Event getEvent(String name)
	{
		File folder = new File("Events/") ; 
		File[] listOfFiles = folder.listFiles() ; 
		for(int i=0; i<listOfFiles.length; i++)
		{
			if(listOfFiles[i].getName().equals(name) == true)
			{
				/* Read from the database and return. */ 
			}
		}
		return null ; 
	}
	public ArrayList<Event> getAllEvents()
	{
		ArrayList<Event> listOfEvents = new ArrayList<Event>() ; 
		File folder = new File("Events/") ; 
		File[] listOfFiles = folder.listFiles() ; 
		for(int i=0; i<listOfFiles.length; i++)
		{
			/* Read from database and add to listOfEvents. */ 
		}
		return listOfEvents ; 	
	}
	public void writeAllEvents(ArrayList<Event> eventList)
	{
		for(int i=0; i<eventList.size(); i++)
		{
			/* Write to database here. */ 
		}
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
	
