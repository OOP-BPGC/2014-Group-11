package zephyr;

import java.util.* ;

public abstract class Event
{
<<<<<<< HEAD:Console/Event.java
	private String venue; 	
	private int year ; 
	private int month ; 
	private int date ; 
	private String name ; 
	//abstract ArrayList<Person> getPeople() ;
=======
	protected String venue; 	
	protected int year ; 
	protected int month ; 
	protected int date ;
    
	abstract ArrayList<Student> getStudent();
    
>>>>>>> 5fe2ecfc3649e7c6863bdae51a4d6dd5ce8b5bf5:src/zephyr/Event.java
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
