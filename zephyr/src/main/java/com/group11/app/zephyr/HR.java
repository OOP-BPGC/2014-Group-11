package com.group11.app.zephyr ; 
import java.util.* ;
import java.sql.*; 
import com.group11.app.zephyr.* ; 
class HR extends Student 
{
	public void registerStudent(ArrayList<Student> list, Competition cmp) 
	{
		
		try
		{
		Connection c = DriverManager.getConnection("jdbc:sqlite:common");
		Statement stmt = c.createStatement() ; 
		for(int i=0; i<list.size(); i++)
		{
			stmt.executeQuery("insert into participants values (" + cmp.id + ", " + list.get(i).id + ") ; ") ; 
		}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace() ; 
		}
	}
}
