import static org.junit.Assert.assertEquals ; 
import org.junit.Test ; 
import java.sql.* ;
import java.lang.* ; 
public class TesRegister
{
	@Test
		public void testccheckIfAlreadyPresent()
		{
			Student s1 = new Student("Jayanti","J","AH1");		//creating an object of student
			s1.id = "username";									//assigning a random username
			s1.password = "password";							//assigning a random password
			
			Register r = new Register(s1);
			
			s1.registerStudent();								//manually registering the student for the event
			
			try
			{
				assertTrue(r.checkIfAlreadyPresent());			//checking the method
			}
			catch(CannotFindStudent cfs)
			{
				fail("ERROR OCCURED");							//should not reach here
			}
		}
} 
