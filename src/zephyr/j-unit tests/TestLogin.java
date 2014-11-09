import static org.junit.Assert.assertEquals ; 
import org.junit.Test ; 
import java.sql.* ;
import java.lang.* ; 
public class TestLogin
{
	@Test
		public void testcheckCredentials()
		{
			Student s1 = new Student("Srinath","R","CH4");		//creating an object of student
			s1.id = "username";									//assigning a random username
			s1.password = "password";							//assigning a random password
			
			Login l = new Login(s1);
			
			try
			{
				assertTrue(l.checkCredentials());				//checking the method
			}
			catch(CannotFindStudent cfs)
			{
				fail("ERROR OCCURED");							//should not reach here
			}
		}
} 
