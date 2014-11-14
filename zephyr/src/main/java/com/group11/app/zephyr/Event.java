package zephyr ; 
import java.util.* ;

public abstract class Event
{
	public String venue; 	
	public int year ; 
	public int month ; 
	public int date ; 
	public String name ; 
	//abstract ArrayList<Person> getPeople() ;

	//abstract ArrayList<Student> getStudent();
    
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
