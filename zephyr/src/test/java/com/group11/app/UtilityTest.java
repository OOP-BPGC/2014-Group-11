package com.group11.app ; 
import static junit.framework.Assert.* ; 
import junit.framework.Test ; 
import java.sql.* ;
import java.lang.* ; 
import com.group11.app.zephyr.* ; 
public class UtilityTest
{
		public void testLoginCorrect()
		{
			int id = 13019 ; 
			String pass = "yoyo" ; 
			Statement stmt = null ;	
			Utility ut = new Utility() ; 
			boolean thrown1 = false, thrown2 = false, thrown3=false  ; 
			try
			{
				ut.loginCorrect(id, pass, stmt) ;
			}
			catch(NullPointerException ex)
			{
				thrown1 = true ; 
			}
			catch(SQLException ex)
			{
				thrown2 = true;  
			}
			assertEquals(thrown1, true) ; 
			try
			{
				thrown2 = false ; 
				Class.forName("org.sqlite.JDBC");
				Connection c = DriverManager.getConnection("jdbc:sqlite:common");
				stmt = c.createStatement() ; 
				assertEquals(ut.loginCorrect(13019,"yoyo",stmt), true) ; 
				assertEquals(ut.loginCorrect(13019, "yoyoy", stmt), false) ; 
			}
			catch(SQLException ex)
			{
				thrown2 = true ;
			}
			catch(ClassNotFoundException ex)
			{
				System.out.println("Exception thrownn...") ; 
				thrown3 = true ; 
			}
			assertEquals(thrown2,false) ; 
			assertEquals(thrown3, false) ; 
		}
} 
