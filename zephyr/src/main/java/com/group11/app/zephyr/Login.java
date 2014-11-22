package com.group11.app.zephyr;
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
                    Class.forName("org.sqlite.JDBC");
                    Connection c = DriverManager.getConnection("jdbc:sqlite:/var/lib/tomcat7/webapps/zephyr/data/common");
                    Statement stmt = c.createStatement() ; 
                    Utility ut = new Utility() ;
                    return ut.loginCorrect(s.id, s.password, stmt)  ;
				}
				catch(SQLException ex)
				{
						ex.printStackTrace() ; 
                        return false ; 
				}

                catch(ClassNotFoundException ex) {
                    ex.printStackTrace();
                    return false;
                }
		}
}
