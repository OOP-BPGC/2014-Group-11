package com.group11.app.zephyr;
import java.sql.*; 

public class Pass implements DatabaseEntry
{
	int id ;
	public Performance perf ;
	public String name ; 
	public String path ; 

	public Pass(int i, String n, String p)
	{
		id = i ; 
		name = n ; 
		path = p ; 
	}
	public void putToDatabase()
	{

		try
		{
		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:common");
		Statement stmt = c.createStatement() ; 
		stmt.executeQuery("INSERT INTO passes values(\" " + name +  "\", " + id + ", \"" + path + "\")") ; 
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
}
