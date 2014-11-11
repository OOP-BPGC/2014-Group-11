/* Main application class which launches the console application.*/ 
package console ; 
import java.util.* ; 
import java.io.* ; 
import java.sql.*; 
import zephyr.*  ;
import zephyr.util.Utility ; 

public class Application
{
	public static Scanner sc = new Scanner(System.in) ; 
	public static Utility ut = new Utility() ; 
	public static Console cn = System.console() ; 
	public static Connection c = null ; 
	public static Statement stmt = null ; 
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException
	{

		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:common");
		stmt = c.createStatement() ; 
		int stateVar = 1 ; 
		int opt = 0 ; 
		if(cn == null)
		{
			System.out.println("Couldn't get terminal... Aborting") ; 
			System.exit(0) ; 
		}
		System.out.println("Welcome to our database editor.") ; 	
		while(true)
		{
			/* Stage 1 of logging in. */ 
			if(stateVar == 1)
			{
				try
				{
					System.out.println("\u001b[2J\u001b[H") ; 
					System.out.println("Please choose the required option:-\n1)Login\n2)Exit") ; 
					opt = sc.nextInt() ; 
					if(opt == 1)
					{
						System.out.print("Username: ") ; 
						int username = sc.nextInt() ;
						System.out.print("Password: ") ;  
						String password = new String(cn.readPassword()) ;  
						if(ut.loginCorrect(username, password, stmt) == true)
						{
							stateVar = 2 ; 
							System.out.println("You have succesfully logged in.") ; 
						}
					}
					else
					{
						System.out.println("Thank you for using our program.") ; 
						System.exit(0) ; 
					}
				}
				catch(InputMismatchException ex)
				{
					System.out.println("Exception : " + ex.getMessage()) ; 
					sc.nextLine() ;  // To clear the buffer. 
					sc.nextLine() ; 
					stateVar = 1 ; 
					continue ; 
				}
			}
			else if(stateVar == 2)
			{
				try
				{
					System.out.println("\u001b[2J\u001b[H") ; 	
					System.out.println("Please choose the required option:- \n1)T-Sirts\n2)Passes\n3)Participants\n4)Performances\n5)Competitions\n6)Back") ; 
					opt =  sc.nextInt() ; 
					if(opt == 3)
					{
						ut.listAllParticipants() ; 
						sc.nextLine() ; 
						sc.nextLine() ; 
					}
					else if (opt == 6)
					{
						stateVar = 1 ; 
						continue ; 
					}
				}
				catch(InputMismatchException ex)
				{
					stateVar = 2 ; 
					sc.nextLine() ; 
					sc.nextLine() ; 
					continue ; 
				}
			}
					
		}
	}

}
