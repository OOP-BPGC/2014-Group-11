import org.junit.runner.* ;  
import org.junit.Test ; 
import org.junit.runner.JUnitCore ;
import org.junit.runner.notification.Failure ; 
public class TestRunner 
{
	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(TestUtility.class) ; 
		for(Failure fail : result.getFailures() )	
		{
			System.out.println(fail.toString()) ; 
			System.out.println(fail.getTrace()) ; 
			System.out.println(fail.getDescription()) ; 
		}
		System.out.println(result.wasSuccessful()) ; 
	}
}
