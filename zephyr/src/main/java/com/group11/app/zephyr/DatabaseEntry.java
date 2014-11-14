package zephyr;
import java.sql.* ; 

public interface DatabaseEntry
{
	public void putToDatabase(Statement stmt) ; 	
}
