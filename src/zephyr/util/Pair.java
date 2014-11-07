package zephyr.util;

import zephyr.*;

public class Pair
{
	Student p ; 
	int rank ; 
	public Pair(String fn, String ln, String host, String ty, int rn)
	{
		p = new Student(fn,ln,host,ty) ; 
		rank = rn ; 
	}
	public int getRank()
	{
		return rank ; 
	}
	public Student getStudent()
	{
		return p ; 
	}
}
