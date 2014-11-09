import static org.junit.Assert.assertEquals ; 
import org.junit.Test ; 
import java.sql.* ;
import java.lang.* ; 
public class TestPerson
{
	@Test
		public void testgetCompetitions()
		{
			boolean thrown1 = false;
			boolean thrown2 = false;
			Statement stmt = null ;
			int ID = 1234;																	//random value assigned for checking
			Person p = new Person(ID,"Sumit","Khaitan","CH5");								//creating an instance of person with ID = 1234
			Competition cmp = new Competition ( "football", "lt-3", 2015, 7, 17, ID, 0);	//registering a person for competition with ID = 1234
			ArrayList<Competition> al1= new ArrayList<Competition>();
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection c = DriverManager.getConnection("jdbc:sqlite:common");
				stmt = c.createStatement() ; 
				
				al1 = p.getCompetitions(stmt);												//getting the list of the competitions for the person
				
				if(al1.contains(cmp))														//checking the list for the given competition
					assertTrue(true);
				else
					fail("Person with the id was not detected");
			}
			catch(SQLException ex)
			{
				System.out.println("SQL Exception thrown") ;
				thrown1 = true ;
			}
			catch(ClassNotFoundException ex)
			{
				System.out.println("ClassNotFoundException thrown") ; 
				thrown2 = true ; 
			}
			assertEquals(thrown1,false) ; 
			assertEquals(thrown2,false) ; 
		}
} 
