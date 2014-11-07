import java.util.* ; 
import java.nio.file.* ; 
import java.io.* ; 
class Zephyr /* This class will contain all the info regarding zephyr at inital loading of application. */ 
{
	public ArrayList<Event> events = new ArrayList<Event> () ; 

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
}	
