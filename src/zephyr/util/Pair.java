package zephyr.util;

import zephyr.*;

public class Pair
{
	Student p ; 
	int rank ; 
<<<<<<< HEAD:Console/Pair.java
=======
	public Pair(String fn, String ln, String host, String ty, int rn)
	{
		p = new Student(fn,ln,host,ty) ; 
		rank = rn ; 
	}
>>>>>>> 5fe2ecfc3649e7c6863bdae51a4d6dd5ce8b5bf5:src/zephyr/util/Pair.java
	public int getRank()
	{
		return rank ; 
	}
	public Student getStudent()
	{
		return p ; 
	}
}
