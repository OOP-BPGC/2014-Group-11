/* Main application class which launches the console application.*/ 
// TODO :- Add support for image as a blob in database. .
// TODO :- Might need to change the name of this class from app to application
package com.group11.app ; 
import java.util.* ; 
import java.io.* ; 
import java.sql.*; 
import zephyr.*  ;
import zephyr.util.* ;

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
										System.out.println("Please choose the required option:- \n1)T-Sirts\n2)Passes\n3)Participants\n4)Performances\n5)Competitions\n6)Controls\n7)Back") ; 
										opt =  sc.nextInt() ; 
										if(opt == 3)
										{
												participantsLoop(stmt) ;
										}
										else if (opt == 1)
										{
												tshirtLoop(stmt) ; 
										}
										else if (opt == 6)
										{
												controlsLoop(stmt) ; 
										}
										else if (opt == 7)
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
										ut.printAllDetails(pList.get(opt-1), stmt) ; 
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
								/* Code to update database here. */ 
						}
						else 
						{
								return ; 
						}
				}
		}
		public static void controlsLoop(Statement stmt)
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
						}
						else if(stateVar == 2)
						{
								/* Code to update databse.*/ 
						}
						else
						{
								return ; 
						}
				}
		}		

}
