package com.group11.app.zephyr;
import java.sql.* ; 
public class Register  
{
	Student s;

	public Register(Student su) 
	{
		this.s = su;
	}

	public void registerStudent() 
	{
		try
		{
			Connection c = DriverManager.getConnection("jdbc:sqlite:common");
			Statement stmt = c.createStatement() ; 
			if(!checkIfAlreadyPresent())
				s.putToDatabase() ;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace() ; 
		}
	}

	public boolean checkIfAlreadyPresent() 
	{

		try
		{
			Connection c = DriverManager.getConnection("jdbc:sqlite:common");
			Statement stmt = c.createStatement() ; 
			ResultSet rs = stmt.executeQuery("SELECT * FROM person WHERE id=" + s.id) ; 
			return rs.next() ;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace() ; 
		}
		return false ; 
	}

}
