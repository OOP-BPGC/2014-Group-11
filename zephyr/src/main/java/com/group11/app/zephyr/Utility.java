package com.group11.app.zephyr;

import java.util.* ;
import java.io.* ; 
import java.nio.file.*; 
import java.sql.* ; 
/* This class will provide all the database related functionality. */ 
/* The database file of events will be made in the Events/ folder. */ 
public class Utility
{
	// -----------------------------------------------------------------------------------------// 
	/* To be tested.*/ 
	public boolean loginCorrect(int username, String password, Statement stmt) throws SQLException 
	{
		ResultSet rs = stmt.executeQuery("SELECT * FROM Person WHERE id = " + username) ; 
		while(rs.next() == true)
		{
			if(rs.getString("password").equals(password)) 
				return true ; 
		}
		return false ;
	}

	// ----------------------------------------------------------------------------------------------------// 
	public static List<Integer>  listAllParticipants(Statement stmt)
	{
		try
		{
			List<Integer> pList = new ArrayList<>() ; 
			//Connection c = null ; 
			//Statement stmt = null ; 
			//c = DriverManager.getConnection("jdbc:sqlite:common") ; 
			//stmt = c.createStatement() ; 
			ResultSet rs = stmt.executeQuery("SELECT * FROM Person") ; 
			int i = 1 ; 
			while(rs.next() == true)
			{
				pList.add(rs.getInt("id")) ; 
				System.out.format("%d) %-20s%-20s%-4s%-5d", i, rs.getString("fname"), rs.getString("lname"), rs.getString("hostel"), rs.getInt("id")) ; 
				i++ ; 
				System.out.println() ; 
			}
			return pList ; 
		}		
		catch(SQLException ex)
		{	
			System.out.println(ex.getMessage()) ;
			return null ; 
		}
	}
	// --------------------------------------------------------------------------------------------------------------//
	public static void printAllDetails(ArrayList<TShirt> tList, ArrayList<Pass> pList, ArrayList<Competition> cList ) throws SQLException 
	{
		System.out.println("Competitons : ") ; 
		System.out.format("|********************|********************|**********|**********|**********|\n") ; 
		System.out.format("|%-20s|%-20s|%-10s|%-10s|%-10s|\n", "NAME", "VENUE", "DATE", "RANK", "ID") ; 
		for(int i=0; i<cList.size(); i++)
		{
			System.out.format("|********************|********************|**********|**********|**********|\n") ; 
			System.out.format("|%-20s|%-20s|%-10s|%-10s|%-10s|\n", cList.get(i).name, cList.get(i).venue, cList.get(i).date + "/" + cList.get(i).month + "/" + cList.get(i).year,cList.get(i).rank , cList.get(i).id) ; 
		}

		System.out.format("|********************|********************|**********|**********|**********|\n") ; 
		System.out.println("TShirt: ") ; 
		System.out.format("|*****|*****|*****|*****|*****|\n") ; 
		System.out.format("|%-5s|%-5s|%-5s|%-5s|%-5s|\n", "ID", "QS", "QM", "QL", "QXL") ; 
		for(int i=0; i<tList.size(); i++)
		{
			System.out.format("|*****|*****|*****|*****|*****|\n") ; 
			System.out.format("|%-5d|%-5d|%-5d|%-5d|%-5d|\n", tList.get(i).id, tList.get(i).qs, tList.get(i).qm, tList.get(i).ql, tList.get(i).qxl) ; 
		}
		System.out.format("|*****|*****|*****|*****|*****|\n") ; 
	}	
	// ------------------------------------------------------------------------------------------------------------// 
	public List<Integer>  listAllTShirts(Statement stmt) throws SQLException  // lists all the tshirt methods. 
	{
		ResultSet rs = stmt.executeQuery("SELECT * FROM tshirt") ; 
		List<Integer> tList = new ArrayList<>() ; 
		System.out.format("|********************|*****|\n"); 
		System.out.format("|%-20s|%-5s|\n", "NAME", "ID") ; 
		while(rs.next() == true)
		{
			System.out.format("|********************|*****|\n"); 
			System.out.format("|%-20s|%-5d|\n", rs.getString("name"), rs.getInt("tid")) ; 
			tList.add(rs.getInt("tid")) ; 
		}
		System.out.format("|********************|*****|\n"); 
		return tList ; 
	}
	public void printTShirtDetails(int id, Statement stmt) throws SQLException // lists details of individual tshirt. 
	{

		System.out.format("|********************|*****|\n"); 
		System.out.format("|%-20s|%-5s|\n", "NAME", "ID") ; 
		System.out.format("|********************|*****|\n"); 
		ResultSet rs = stmt.executeQuery("SELECT * FROM tshirt WHERE tid=" + id) ; 
		System.out.format("|%-20s|%-5d|\n", rs.getString("name"), rs.getInt("tid")) ; 
		System.out.format("|********************|*****|\n"); 
		System.out.format("\n\n") ; 
		rs = stmt.executeQuery("SELECT * FROM tshirtlist WHERE tid=" + id) ; 
		boolean looped = false ; 
		boolean first = false ; 
		while(rs.next() == true)
		{
			if(first == false)
			{

				System.out.format("|*****|*****|*****|*****|*****|*****|\n") ; 	
				System.out.format("|%-5s|%-5s|%-5s|%-5s|%-5s|%-5s|\n", "TID", "ID", "QS", "QM", "QL", "QXL") ; 
				System.out.format("|*****|*****|*****|*****|*****|*****|\n") ; 	
				System.out.format("|%-5d|%-5d|%-5d|%-5d|%-5d|%-5d|\n", rs.getInt("tid"), rs.getInt("pid"), rs.getInt("s"), rs.getInt("m"), rs.getInt("l"),rs.getInt("xl")) ; 
				first = true ; 
			}
			else
			{
				System.out.format("|*****|*****|*****|*****|*****|*****|\n") ; 	
				System.out.format("|%-5d|%-5d|%-5d|%-5d|%-5d|%-5d|\n", rs.getInt("tid"), rs.getInt("pid"), rs.getInt("s"), rs.getInt("m"), rs.getInt("l"),rs.getInt("xl")) ; 
			}
			looped = true ; 
		}
		if(looped == true)
		{
			System.out.format("|*****|*****|*****|*****|*****|*****|\n") ; 
		}

	}

	public List<Integer> printCompetitions(Statement stmt) throws SQLException 
	{
		List<Integer> idList = new ArrayList<>() ; 
		ResultSet rs = stmt.executeQuery("SELECT * from competition") ; 
		System.out.println("Competitons : ") ; 
		System.out.format("|********************|********************|**********|**********|\n") ; 
		System.out.format("|%-20s|%-20s|%-10s|%-10s|\n", "NAME", "VENUE", "DATE", "ID") ; 
		while(rs.next() == true)	
		{
			System.out.format("|********************|********************|**********|**********|\n") ; 
			System.out.format("|%-20s|%-20s|%-10s|%-10s|\n", rs.getString("name"), rs.getString("venue"), rs.getInt("date") + "/" + rs.getInt("month") + "/" + rs.getInt("year") , rs.getInt("id")) ; 
			idList.add(rs.getInt("id")) ; 
		}
		System.out.format("|********************|********************|**********|**********|\n") ; 
		return idList ; 
	}


	public void printCompetitionDetails(Statement stmt, int id) throws SQLException 
	{
		ResultSet rs = stmt.executeQuery("SELECT * from ranklist where eid=" +id) ; 
		List<Integer> idList = new ArrayList<>() ; 
		while(rs.next() == true)
		{
			idList.add(rs.getInt("pid")) ; 
			System.out.println(rs.getInt("pid")) ; 
		}
		for(int i=0; i<idList.size(); i++)
		{
			rs=stmt.executeQuery("SELECT * from person where id="+idList.get(i)) ; 
			while(rs.next() == true)
			{
				System.out.format("%d) %-20s%-20s%-4s%-5d", i, rs.getString("fname"), rs.getString("lname"), rs.getString("hostel"), rs.getInt("id")) ; 
				i++ ; 
				System.out.println() ; 
			}
		}
	}

}
