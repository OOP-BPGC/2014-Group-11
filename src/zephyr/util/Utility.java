package zephyr.util;

import java.util.* ;
import java.io.* ; 
import java.nio.file.*; 
import java.sql.* ; 
/* This class will provide all the database related functionality. */ 
/* The database file of events will be made in the Events/ folder. */ 
public class Utility
{
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
		public static void printAllDetails(int id, Statement stmt ) throws SQLException 
		{
				ResultSet rs = stmt.executeQuery("SELECT * FROM Person WHERE id=" + id)  ; 
				System.out.println("Name : " + rs.getString("fname") + " " + rs.getString("lname")) ; 	
				System.out.println("ID : " + rs.getInt("id")) ; 
				System.out.println("Hostel: " + rs.getString("hostel")) ; 
				if(rs.getInt("type") == 0)
				{
						System.out.println("Type: student") ; 
				}
				else	
				{
						System.out.println("Type: HR") ; 
				}
				System.out.println("Competitons : ") ; 
				rs = stmt.executeQuery("SELECT * FROM ranklist WHERE pid=" + id) ; 
				List<Integer> iList = new ArrayList<>() ; 
				List<Integer> rList = new ArrayList<>() ; 
				while(rs.next() == true)
				{
						//ResultSet rs2 = stmt.executeQuery("SELECT * FROM competition WHERE id=" + rs.getInt("eid")) ; 
						//System.out.println(rs2.getString("name")) ; 
						iList.add(rs.getInt("eid")) ; 
						rList.add(rs.getInt("rank")) ; 
				}
				for(int i=0; i<iList.size(); i++)
				{
						rs = stmt.executeQuery("SELECT * FROM competition WHERE id=" + iList.get(i)) ; 
						System.out.format("|********************|********************|**********|**********|**********|\n") ; 
						System.out.format("|%-20s|%-20s|%-10s|%-10s|%-10s|\n", "NAME", "VENUE", "DATE", "RANK", "ID") ; 
						System.out.format("|********************|********************|**********|**********|**********|\n") ; 
						System.out.format("|%-20s|%-20s|%-10s|%-10s|%-10s|\n", rs.getString("name"), rs.getString("venue"), rs.getInt("date") + "/" + rs.getInt("month") + "/" + rs.getInt("year"), rList.get(i), iList.get(i)) ; 
						System.out.format("|********************|********************|**********|**********|**********|\n") ; 
				}
				rs = stmt.executeQuery("SELECT * FROM tshirtlist WHERE pid=" + id) ; 
				System.out.println("TShirt: ") ; 
				System.out.format("|*****|*****|*****|*****|*****|\n") ; 
				System.out.format("|%-5s|%-5s|%-5s|%-5s|%-5s|\n", "ID", "QS", "QM", "QL", "QXL") ; 
				while(rs.next() == true)
				{
						System.out.format("|*****|*****|*****|*****|*****|\n") ; 
						System.out.format("|%-5d|%-5d|%-5d|%-5d|%-5d|\n", rs.getInt("tid"), rs.getInt("s"), rs.getInt("m"), rs.getInt("l"), rs.getInt("xl")) ; 
				}
				System.out.format("|*****|*****|*****|*****|*****|\n") ; 
		}	
		public List<Integer>  listAllTShirts(Statement stmt) throws SQLException 
		{
			return null ; 
		}
		public void printTShirtDetails(int id, Statement stmt)
		{
			; 
		}
}
