package com.group11.app ; 
import static junit.framework.Assert.assertEquals ;
import static junit.framework.Assert.assertTrue;
import junit.framework.Test ; 
import java.sql.* ;
import java.util.* ;
import com.group11.app.zephyr.* ; 

public class CompetitionTest
{
		public void testgetStudents()
		{
				boolean thrown1 = false;
				boolean thrown2 = false;
				Statement stmt = null ;
				int ID = 1234;	//random value assigned for checking

				//assuming student with relevant details is present in the db
				Student p = new Student(ID,"Sumit","Khaitan","CH5");	 //creating an instance of person with ID = 1234
				p.password="lollypop" ; 
				Competition cmp = new Competition ( "football", "lt-3", 2015, 7, 17, 123, 0);

				ArrayList<Student> al1= new ArrayList<Student>();
				try
				{
						Class.forName("org.sqlite.JDBC");
						Connection c = DriverManager.getConnection("jdbc:sqlite:common");
						stmt = c.createStatement() ; 

						al1 = cmp.getStudent(stmt);													//getting the list of the persons in the competition

						//checking if student is present in the db;
						for(Student s: al1) 
						{
								if(s.getID() == p.getID())
								{
										assertTrue(true);
								}
								else
								{
										assertTrue(false) ;
								}
						}
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
