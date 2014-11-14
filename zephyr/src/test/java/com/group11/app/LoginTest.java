package com.group11.app ; 
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static junit.framework.Assert.* ; 
import java.sql.* ;
import java.lang.* ; 
import com.group11.app.zephyr.* ; 
public class LoginTest
{
    //@Test
    public void testcheckCredentials()
    {
        Student s1 = new Student(13123,"Anurag","Rai","AH4");		//creating an object of student        
		s1.password="password" ;
        Login l = new Login(s1);			          
		assertFalse(l.checkCredentials()) ; 
		s1 = new Student(13019, "Pratik", "Singhal", "AH7") ; 
		s1.password="yoyo" ;
		l = new Login(s1) ; 
        assertTrue(l.checkCredentials());				//checking the method     
     
    }
     
    
} 
