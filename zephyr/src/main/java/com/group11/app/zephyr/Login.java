package zephyr;
import java.sql.* ; 

public class Login 
{
		Student s; // can be both Student as well as HR. Ha! Power of polymorphism

		public Login(Student s) 
		{        
				this.s = s;
		}

		public boolean checkCredentials() 
		{
				try
				{
						Connection c = DriverManager.getConnection("jdbc:sqlite:common");
						Statement stmt = c.createStatement() ; 
						Utility ut = new Utility() ; 
						return ut.loginCorrect(s.id, s.password, stmt)  ;
				}
				catch(SQLException ex)
				{
						ex.printStackTrace() ; 
						return false ; 
				}
		}
}
