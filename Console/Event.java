import java.util.* ; 
abstract class Event
{
	private String venue; 	
	private int year ; 
	private int month ; 
	private int date ; 
	abstract ArrayList<Person> getPeople() ;
	public int getYear()
	{
		return year ; 
	}
	public int getMonth()
	{
		return month ; 
	}
	public int getDate()
	{
		return date ; 
	}
	public void setYear(int ye)
	{
		year = ye ; 
	}
	public void setMonth(int mon)
	{
		month = mon ; 
	}
	public void setDate(int da)
	{
		date = da ; 
	}
}
