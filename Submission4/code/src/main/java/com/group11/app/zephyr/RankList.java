package com.group11.app.zephyr ; 
import java.sql.* ; 
import java.util.* ; 
class RankList
{
	public RankList()
	{
		; 
	}
	public ArrayList<Tuple> getRanks()
	{
		try
		{
		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:common");
		Statement stmt = c.createStatement() ; 
		List<Integer> eList = new ArrayList<>() ; 
		List<Integer> pList = new ArrayList<>() ; 
		List<Integer> rList = new ArrayList<>() ; 
		ResultSet rs = stmt.executeQuery("SELECT * from ranklist") ; 
		while(rs.next() == true)
		{
			eList.add(rs.getInt("eid")) ; 
			pList.add(rs.getInt("pid")) ; 
			rList.add(rs.getInt("rank")) ; 
		}
		ArrayList<Student> sList = new ArrayList<Student>() ; 
		ArrayList<Competition> cList = new ArrayList<Competition> () ;
		for(int i=0; i<pList.size(); i++)
		{
			rs = stmt.executeQuery("SELECT * from Person where id= " + pList.get(i)) ; 
			rs.next()  ; 
			sList.add(new Student(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("hostel"))) ; 
		}
		for(int i=0; i<eList.size(); i++)
		{
			rs = stmt.executeQuery("SELECT * from competition where id=" + eList.get(i)) ; 
			rs.next() ; 
			cList.add(new Competition(rs.getString("name") , rs.getString("venue"), rs.getInt("year"), rs.getInt("month"), rs.getInt("date"), eList.get(i), -1)) ; 
		}
		ArrayList<Tuple> tList = new ArrayList<Tuple>() ; 
		for(int i=0; i<pList.size(); i++)
		{
			tList.add(new Tuple(sList.get(i), cList.get(i), rList.get(i))) ; // get integer from Integer. 
		}
		return tList ;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace() ; 
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace() ; 
		}
		return new ArrayList<Tuple>() ; 
	}
}

