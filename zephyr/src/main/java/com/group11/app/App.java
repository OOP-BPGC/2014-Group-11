/* Main application class which launches the console application.*/ 
// TODO :- Add support for image as a blob in database. .
// TODO :- Might need to change the name of this class from app to application
package com.group11.app ; 
import java.util.* ; 
import java.io.* ; 
import java.sql.*; 
import com.group11.app.zephyr.*  ;

public class App
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
					System.out.println("Input is not in correct format\nPress any key to continue") ; 
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
					System.out.println("Please choose the required option:- \n1)T-Shirts\n2)Passes\n3)Participants\n4)Competitions\n5)Back") ; 
					opt =  sc.nextInt() ; 
					if(opt == 3)
					{
						participantsLoop(stmt) ;
					}
					else if (opt == 1)
					{
						tshirtLoop(stmt) ; 
					}
					else if (opt == 4)
					{
						competeLoop(stmt) ; 
					}
					else if (opt == 2)
					{
						passLoop(stmt) ; 
					}
					else if (opt == 5)
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
	public static void participantsLoop(Statement stmt) throws SQLException 
	{
		int opt = 0 ; 
		int stateVar = 1  ; 
		while(true)
		{
			if(stateVar == 1)
			{
				System.out.println("\u001b[2J\u001b[H") ;
				System.out.println("Please select the relevant option :-") ; 
				System.out.println("The list of participants is :- ") ; 
				List<Integer> pList =  ut.listAllParticipants(stmt) ;
				opt = sc.nextInt() ;
				if((opt > 0)&&(opt < pList.size()+1))
				{
					System.out.println("\u001b[2J\u001b[H") ;		
					Student s = new Student(pList.get(opt-1)) ; 
					ut.printAllDetails(s.getTShirts(stmt),s.getPasses(stmt), s.getPerformance(stmt)) ;  
					sc.nextLine() ; 
					sc.nextLine() ; 
				}
				else
				{
					return  ; 
				}
			}
		} 
	}
	public static void tshirtLoop(Statement stmt) throws SQLException
	{
		int opt = 0 ; 
		int stateVar = 1 ; 
		while(true)
		{
			System.out.println("\u001b[2J\u001b[H") ;
			System.out.println("Please select the relevant option :- ") ; 
			System.out.println("1)View details\n2)Add details") ; 
			stateVar = sc.nextInt() ; 
			if(stateVar == 1)
			{
				System.out.println("\u001b[2J\u001b[H") ;
				System.out.println("Please select the relevant option.") ; 
				System.out.println("The list of available tshirts are :- ") ; 
				List<Integer> tList = ut.listAllTShirts(stmt) ; 
				opt = sc.nextInt() ; 
				if((opt > 0)&&(opt < tList.size() + 1))
				{
					System.out.println("\u001b[2J\u001b[H") ;
					ut.printTShirtDetails(tList.get(opt-1), stmt);
					sc.nextLine() ; 
					sc.nextLine() ; 
				}
				else
				{
					return  ; 
				}
			}
			else if (stateVar == 2)
			{
				System.out.println("Please fill in the following details to update the tshirt database.") ; 
				String name, path ; 
				int id ; 
				System.out.print("TShirt name: ") ; 
				sc.nextLine() ; 
				name = sc.nextLine() ; 
				System.out.print("TShirt picture path: ") ; 
				path = sc.nextLine() ; 
				System.out.print("TShirt id: ") ; 
				id = sc.nextInt() ; 
				TShirt t = new TShirt(name, path, id) ; 
				t.putToDatabase(stmt) ; 
			}
			else 
			{
				return ; 
			}
		}
	}
	public static void passLoop(Statement stmt) throws SQLException 
	{
		while(true)
		{
			System.out.println("\u001b[2J\u001b[H") ;
			System.out.println("Please select the relevant option :- ") ; 
			System.out.println("1)View details\n2)Add details") ; 
			int stateVar = sc.nextInt() ;
			if(stateVar == 1)
			{
				System.out.println("\u001b[2J\u001b[H") ;
				System.out.println("Please select the pass no to view more details about it.") ; 
				List<Integer> idList = ut.printPasses(stmt) ; 
				int opt = sc.nextInt() ; 
				if((opt > 0)&&(opt <= idList.size()))  
				{
					ut.printPassDetails(stmt, idList.get(opt-1)) ; 
				}
				sc.nextLine() ; 
				sc.nextLine() ; 
				/* Add code to view the details. */ 
			}
			else if(stateVar == 2)
			{
				/* Code to update databse.*/ 
				System.out.println("\u001b[2J\u001b[H") ;
				sc.nextLine() ; 
				System.out.print("Name: " ) ; 
				String name = sc.nextLine() ; 
				int id ;
				System.out.print("ID: ") ; 
				id = sc.nextInt() ; 
				String path = sc.nextLine() ; 
				Pass p = new Pass(id, name, " ")  ; 
				p.putToDatabase(stmt) ; 
				System.out.println("Written to database") ; 
				sc.nextLine() ; 
				sc.nextLine() ; 
			}
			else
			{
				return ; 
			}
		}
	}		


	public static void competeLoop(Statement stmt) throws SQLException 
	{
		while(true)
		{
			System.out.println("\u001b[2J\u001b[H") ;
			System.out.println("Please select the relevant option :- ") ; 
			System.out.println("1)View details\n2)Add details") ; 
			int stateVar = sc.nextInt() ;
			if(stateVar == 1)
			{
				/* Add code to view the details. */ 
				System.out.println("\u001b[2J\u001b[H") ;
				System.out.println("Please select the competition number to view more details about it.") ; 
				List<Integer> idList = ut.printCompetitions(stmt) ; 
				int opt = sc.nextInt() ; 
				if((opt > 0)&&(opt <= idList.size()))
				{
					ut.printCompetitionDetails(stmt, idList.get(opt-1))  ;
					sc.nextLine() ; 
					sc.nextLine() ; 
				}

			}
			else if(stateVar == 2)
			{
				System.out.println("\u001b[2J\u001b[H") ;
				System.out.println("Please add the following details..") ; 
				sc.nextLine() ; 
				System.out.print("Name: " ) ; 
				String name = sc.nextLine() ; 
				System.out.print("Venue: "); 
				String ven = sc.nextLine() ; 
				System.out.print("Day: ") ; 
				int day  = sc.nextInt() ; 
				System.out.print("Month: ") ; 
				int mon = sc.nextInt() ; 
				System.out.print("Year: " ) ; 
				int yea = sc.nextInt() ; 
				System.out.print("ID: " ) ; 
				int id = sc.nextInt() ; 
				Competition comp = new Competition(name, ven, yea, mon, day, id, -1) ; 
				comp.putToDatabase(stmt, true) ; 
				sc.nextLine() ; 
				sc.nextLine() ; 
			}
			else
			{
				return ; 
			}
		}
	}


}
