package zephyr;

import java.util.* ;

public abstract class Event
{
    protected String venue; 	
    protected int year ; 
    protected int month ; 
    protected int date ;
    protected String name;
    
    abstract ArrayList<Student> getStudent();
    
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
