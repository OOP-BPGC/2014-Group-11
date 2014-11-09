package zephyr ; 
import java.util.* ; 
import zephyr.* ;  
import java.sql.* ;
public class Student implements DatabaseEntry
{
	private String fName ; 
	private String lName ; 
	private String hostel ; 
	private int  id ; 
	private String password ; 
	public Student(int i, String fn, String ln, String host)
	{
		id = i ; 
		fName = fn ; 
		lName = ln ; 
		hostel = host ; 
	}
	public void setPassword(String pass)
	{
		password = pass ; 
	}
	public void setFName(String fn)
	{
		this.fName = fn ; 
	}
	public void setLName(String ln)
	{
		this.lName = ln ; 
	}
	public void setHostel(String host)
	{
		hostel = host ; 
	}
	public String getPassword()
	{
		return password ; 
	}
	public String getFName()
	{
		return fName ; 
	}
	public String getLName()
	{
		return lName ; 
	}
	public String getHostel()
	{
		return hostel ; 
	}
	//public ArrayList<TShirt> getTShirts()
	//{
	//	/* Query DataBase. */
	//}
	//public ArrayList<Pass> getPasses()
	//{Spelling of mentees
	//	/* Query */ 
	//}
	//public void castoll(Event event, int choice) 
	//{
	//	; 
	//}
	//public ArrayList<Pair> getPerformance()
	//{
	//	/* We can use HashMaps also. */ 
	//}	
	/* Writes itself to the database. */ 
	public ArrayList<Competition> getCompetitions(Statement stmt) throws SQLException 
	{
		String sql = "SELECT * FROM Competition WHERE id=" + id ; 
		ResultSet rs = stmt.executeQuery(sql) ; 
		ArrayList<Competition> list = new ArrayList<Competition>() ; 
		while(rs.next() == true)
		{
			list.add(new Competition(rs.getString("name"), rs.getString("venue"), rs.getInt("year"), rs.getInt("month"), rs.getInt("date"), id, rs.getInt("rank"))) ;
		}
		return list ; 
	} 	
	public void putToDataBase(Statement stmt) throws SQLException 
	{
		String sql = "INSERT INTO Person (fname, lname, hostel, id, password, type) VALUES ('" + fName + "','" +lName + "','"+hostel + "',"+id+",'"+password+"',"+0 + ");" ;
		stmt.executeUpdate(sql) ; 
		;	
	}
	// TODO: - Write interfaces for TShirts and Passes. 
	
}
