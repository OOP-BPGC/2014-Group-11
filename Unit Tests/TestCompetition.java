import static org.junit.Assert.assertEquals ;
import static org.junit.Assert.assertTrue;
import org.junit.Test ; 
import java.sql.* ;
import java.lang.* ;

public class TestCompetition
{
	@Test
		public void testgetStudents()
		{
			boolean thrown1 = false;
			boolean thrown2 = false;
			Statement stmt = null ;
			int ID = 1234;																	//random value assigned for checking
			Student p = new Student(ID,"Sumit","Khaitan","CH5","lollypop");								//creating an instance of person with ID = 1234
			Competition cmp = new Competition ( "football", "lt-3", 2015, 7, 17, ID, 0);		//registering a person for competition with ID = 1234
			ArrayList<Student> al1= new ArrayList<Student>();
			try
			{
				Class.forName("org.sqlite.JDBC");
				Connection c = DriverManager.getConnection("jdbc:sqlite:common");
				stmt = c.createStatement() ; 
				
				al1 = cmp.getStudent(stmt);													//getting the list of the persons in the competition
				
				if(al1.contains(p))															//checking the list for the given ID
					assertTrue(true);
				else
					fail("Student with the id was not detected");
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
