import java.util.* ; 
class Person
{
	private String fName ; 
	private String lName ; 
	private String hostel ; 
	private String id ; 
	private String password ; 
	public Person(String id, String fn, String ln, String host)
	{
		fName = fn ; 
		lName = ln ; 
		hostel = host ; 
	}
	public void setFName(String fn)
	{
		this.fName = fn ; 
	}
	public void setLName(String ln)
	{
		this.lName = ln ; 
	}
	public void setHostel(String host)
	{
		hostel = host ; 
	}
	public String getFName()
	{
		return fName ; 
	}
	public String getLName()
	{
		return lName ; 
	}
	public String getHostel()
	{
		return hostel ; 
	}
	public String getType()
	{
		return type ; 
	}
	public ArrayList<TShirt> getTShirts()
	{
		/* Query DataBase. */
	}
	public ArrayList<Passes> getPasses()
	{
		/* Query */ 
	}
	public void poll(Event event, int choice) 
	{
		; 
	} 
	public ArrayList<Pair> getPerformance()
	{
		/* We can use HashMaps also. */ 
	}	
	// TODO: - Write interfaces for TShirts and Passes. 
	
}
