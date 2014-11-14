package com.group11.app ; 
import static junit.framework.Assert.* ; 
import junit.framework.Test ; 
import java.sql.* ;
import java.lang.* ; 
import com.group11.app.zephyr.* ;
public class RegisterTest
{
    public void testccheckIfAlreadyPresent()
    {
        Student s1 = new Student(123, "Jayanti","J","AH1");  //creating an object of student			
		s1.password = "inkypinky" ; 
        Register r = new Register(s1);
			
        r.registerStudent();	//manually registering the student in the db;	
        assertTrue(r.checkIfAlreadyPresent());	//checking the method
    }
} 
