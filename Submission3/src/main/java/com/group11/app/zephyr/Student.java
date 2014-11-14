package com.group11.app.zephyr ; 
import java.util.* ; 
import java.sql.* ;
public class Student
{
		private String fName ; 
		private String lName ; 
		private String hostel ; 
		public int  id ; 
		public String password ; 
		public Student(int i, String fn, String ln, String host)
		{
				id = i ; 
				fName = fn ; 
				lName = ln ; 
				hostel = host ; 
		}
		public Student( int i)
		{
				id = i;
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
		public int getID()
		{
				return id; 
		}
		public String getHostel()
		{
				return hostel ; 
		}
		public ArrayList<TShirt> getTShirts(Statement stmt) throws SQLException 
		{
				ResultSet rs = stmt.executeQuery("SELECT * FROM tshirtlist WHERE pid="+id) ; 
				ArrayList<TShirt> tList = new ArrayList<TShirt>() ; 
				// get the list of tshirt orders.
				while(rs.next() == true)
				{
						tList.add(new TShirt(null, rs.getInt("tid"), rs.getInt("s"), rs.getInt("m"), rs.getInt("l"), rs.getInt("xl"))) ; 
				}
				// now populate the names of the respective ids.
				for(int i=0; i<tList.size(); i++)
				{
						rs = stmt.executeQuery("SELECT * FROM tshirt WHERE tid=" + tList.get(i).id) ; 
						tList.get(i).name = rs.getString("name") ; 
				}
				return tList ; 
				/* Query DataBase. */
		}
		public ArrayList<Pass> getPasses(Statement stmt)
		{
				return new ArrayList<Pass>() ; 
				/* Query */ 
		}
		//public void castoll(Event event, int choice) 
		//{
		//	; 
		//}
		//public ArrayList<Pair> getPerformance()
		//{
		//	/* We can use HashMaps also. */ 
		//}	
		/* Writes itself to the database. */ 
		public ArrayList<Competition> getPerformance(Statement stmt) throws SQLException 
		{
				String sql = "SELECT * FROM ranklist WHERE pid=" + id ; 
				ResultSet rs = stmt.executeQuery(sql) ; // get those competitions where students have participated.
				ArrayList<Integer> eList = new ArrayList<>() ; 
				ArrayList<Competition> cList = new ArrayList<Competition>() ; 
				int i =0 ; 
				while(rs.next() == true)
				{
						eList.add(rs.getInt("eid")) ; 
						cList.add(new Competition(null, null, 0,0,0,eList.get(i),rs.getInt("rank"))) ; 
						i++ ; 
				}
				// now get the name and the dates based on the eid derived above.
				for(i=0; i<eList.size(); i++)
				{
						rs = stmt.executeQuery("SELECT * FROM competition where id=" + eList.get(i)) ; 
						cList.get(i).name = rs.getString("name") ; 
						cList.get(i).venue = rs.getString("venue") ; 
						cList.get(i).year = rs.getInt("year") ; 
						cList.get(i).month = rs.getInt("month") ; 
						cList.get(i).date = rs.getInt("date") ; 
				}
				return cList ; 
		} 	


		public void writeToDataBase(Statement stmt) throws SQLException 
		{
				String sql = "INSERT INTO Person (fname, lname, hostel, id, password, type) VALUES ('" + fName + "','" +lName + "','"+hostel + "',"+id+",'"+password+"',"+0 + ");" ;
				stmt.executeUpdate(sql) ; 
				;	
		}
}
