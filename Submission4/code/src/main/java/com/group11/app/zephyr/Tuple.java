package com.group11.app.zephyr ; 
import java.sql.* ; 
import java.util.* ; 
class Tuple
{
	public Competition comp ; 
	public Student stud ; 
	public int rank;  
	public Tuple(Student s, Competition c, int r)
	{
		comp = c ; 
		stud = s ; 
		rank = r ; 
	}
}
