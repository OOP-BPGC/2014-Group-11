package com.group11.app.zephyr;
import java.sql.*; 

public class Pass implements DatabaseEntry
{
	public int id ;
	public Performance perf ;
	public String name ; 
	public String path ; 

	public Pass(int i, String n, String p)
	{
		id = i ; 
		name = n ; 
		path = p ; 
	}
	public static String getName( int id)
	{	
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:common");
			Statement stmt = c.createStatement() ; 
			ResultSet rs = stmt.executeQuery("SELECT * from passes where id="+id) ; 
			rs.next() ; 
			return rs.getString("name") ; 
		}
		catch(SQLException ex)
		{
			ex.printStackTrace() ; 
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace() ; 
		}
		return " " ; 
	}
	public void putToDatabase()
	{

		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:common");
			Statement stmt = c.createStatement() ; 
			stmt.executeUpdate("INSERT INTO passes values(\" " + name +  "\", " + id + ", \"" + path + "\")") ; 
		}
		catch(SQLException ex)
		{
			ex.printStackTrace() ; 
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace() ; 
		}
	}
	public static int getNoPasses()
	{

		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:common");
			Statement stmt = c.createStatement() ; 
			ResultSet rs = stmt.executeQuery("SELECT * from passes") ; 
			int count = 0 ; 
			while(rs.next() == true)
			{
				count++ ; 
			}
			return count ; 
		}
		catch(SQLException ex)
		{
			ex.printStackTrace() ; 
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace() ; 
		}
		return -1 ; 
	}
}
