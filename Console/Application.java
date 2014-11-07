		/* Main application class which launches the console application.*/ 
import java.util.* ; 
import java.io.* ; 
class Application
{
	public static Scanner sc = new Scanner(System.in) ; 
	public static Utility ut = new Utility() ; 
	public static Console cn = System.console() ; 
	public static void main(String[] args) throws IOException
	{
		boolean exit = false ; 
		if(cn == null)
		{
			System.out.println("Couldn't get terminal... Aborting") ; 
			System.exit(0) ; 
		}
		System.out.println("Welcome to our database editor.") ; 	
		while(exit == false)
		{
			System.out.println("\u001b[2J\u001b[H") ; 
			System.out.println("1) Login") ; 
			System.out.println("2) Exit") ; 
			System.out.println("Please choose the required option: ") ; 
			int opt = sc.nextInt() ; 
			if(opt == 1)	
			{
				exit = loginPage() ; // Not complete yet. 			
			}
			else
			{
				exit = true ; 
			}
		}
		System.out.println("Thank you for using our program.") ; 
	}
	public static boolean loginPage()
	{
		System.out.println("\u001b[2J\u001b[H") ; 
		System.out.println("Please enter the login details") ; 
		System.out.print("Username: ") ;
		String username = cn.readLine() ;	
		System.out.print("Password: ") ; 
		char[] passwordChars = cn.readPassword() ; 
		String password = new String(passwordChars) ; 
		if(ut.loginCorrect(username, password) == true)
		{
			boolean back = true ; 
			while(back == true )
			{
				back = mainPage() ; 
			}
			return back ; 
		}
		else
		{
			System.out.println("Login details incorrect !") ; 
			return false ; 
		}
	}
	/* boolean will tell whether we went back or forward. */ 
	public static boolean mainPage()
	{
			
		System.out.print("Login correct !\nPress any key to continue  ") ; 
		cn.readLine() ; 
		System.out.println("\u001b[2J\u001b[H") ; 
		System.out.flush() ; 
		System.out.println("1) Passes") ; 
		System.out.println("2) T-shirts") ; 
		System.out.println("3) Events") ; 
		System.out.println("4) Back") ; 
		System.out.print("Please enter the correct option number: ")  ;
		int option = sc.nextInt() ; 
		if(option == 1)
		{
			/* Display passses information. */ 
			return false ; 
		}
		else if (option == 2)
		{
			/* Display T-shirts information. */ 
			return false ; 
		}
		else if (option == 3)
		{
			/* Display events information. */ 
			return false ; 
		}
		else if (option == 4)
		{
			/* Go back   */ 
			return false ; 
		}
		else if (option == 5)
		{
			return true ; 
		}
		else 
		{
			System.out.println("Sorry ! Wrong option selected.") ; 
			return false  ; 
		}
	}
}
