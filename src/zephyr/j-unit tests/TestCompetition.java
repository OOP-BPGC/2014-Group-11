import static org.junit.Assert.assertEquals ; 
import org.junit.Test ; 
import java.sql.* ;
import java.lang.* ; 
public class TestCompetition
{
	@Test
		public void testgetPeople()
		{
			Competition c = new Competition ("test","bdome",2015,10,17,1234,2);			//creating an instance of competition
			
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection c = DriverManager.getConnection("jdbc:sqlite:common");
				stmt = c.createStatement() ; 
				
				
			}
			catch(SQLException ex)
			{
				fail("SQL Exception thrown") ;
			}
			catch(ClassNotFoundException ex)
			{
				fail("Class Not Found Exception thrown") ;
			} 
		}
} 
