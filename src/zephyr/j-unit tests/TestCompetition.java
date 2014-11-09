import static org.junit.Assert.assertEquals ; 
import org.junit.Test ; 
import java.sql.* ;
import java.lang.* ; 
public class TestCompetition
{
	@Test
		public void testgetPeople()
		{
			boolean thrown1 = false;
			boolean thrown2 = false;
			Statement stmt = null ;
			int ID = 1234;																	//random value assigned for checking
			Person p = new Person(ID,"Sumit","Khaitan","CH5");								//creating an instance of person with ID = 1234
			Competition c = new Competition ( "football", "lt-3", 2015, 7, 17, ID, 0);		//registering a person for competition with ID = 1234
			ArrayList<Person> al1= new ArrayList<Person>();
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection c = DriverManager.getConnection("jdbc:sqlite:common");
				stmt = c.createStatement() ; 
				
				al1 = c.getPeople(stmt);													//getting the list of the persons in the competition
				
				if(al1.contains(p))															//checking the list for the given ID
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
