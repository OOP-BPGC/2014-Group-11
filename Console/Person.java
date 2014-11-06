import java.util.* ; 
class Person
{
	private String fName ; 
	private String lName ; 
	private String hostel ; 
	private String type ; /* Can be normal, hr or controls */ 
	public Person(String fn, String ln, String host, String ty)
	{
		fName = fn ; 
		lName = ln ; 
		hostel = host ; 
		type = ty ;
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
	public void setType(String ty)
	{
		type = ty ; 
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
}
