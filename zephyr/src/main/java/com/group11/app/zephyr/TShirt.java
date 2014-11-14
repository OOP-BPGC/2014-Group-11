package zephyr;

import java.sql.* ; 

/* TShirt class for representing the TShirt object. */ 
public class TShirt implements DatabaseEntry 
{
		public String name ; 
		public String path ; 
		public int id; 
		public int qs ; 
		public int ql ; 
		public int qm ; 
		public int qxl  ;

		public TShirt(String n, int i, int s, int m, int l, int xl) 
		{
				name = n ; 
				id = i ; 
				qs = s ; 
				qm = m ;
				ql = l ; 
				qxl = xl ; 
				// ; 
		} 
		public TShirt(String n, String p, int i)
		{
				name = n ; 
				path = p ; 
				id = i ; 
		}
		@Override
				public void putToDatabase(Statement stmt) 
				{
						try
						{
								stmt.executeUpdate("INSERT INTO tshirt VALUES(\"" + name + "\", \""+path + "\", " + id + ")") ; 	
								System.out.println("Database succesfully updated !\n") ; 
						}
						catch(SQLException ex)
						{
								ex.printStackTrace() ; 
						}
						; 
				}
}
