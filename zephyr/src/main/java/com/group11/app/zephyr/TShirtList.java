package com.group11.app.zephyr;
import java.sql.*;
import java.util.*;

public class TShirtList implements DatabaseEntry {
    private TShirt tshirt;
    private Student s;
    
    public TShirtList(TShirt tshirt, Student s) {
        this.tshirt = tshirt;
        this.s = s;
    }

    public void putToDatabase() {        
        Connection c = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/var/lib/tomcat7/webapps/zephyr/data/common");
            stmt = c.createStatement() ;

            stmt.executeUpdate("INSERT INTO tshirtlist VALUES(" + tshirt.id + ", " + s.id + ", " + tshirt.qs + ", " + tshirt.qm + ", " + tshirt.ql + ", " + tshirt.qxl + ");");
            

        } 
        catch(SQLException e) 
        {
            e.printStackTrace();            
            
        } 
        catch(ClassNotFoundException e)
        {
            e.printStackTrace(); 
        }
        finally 
        {
            try 
            {
                stmt.close();
            } 
            catch(SQLException e) 
            {
                e.printStackTrace();
            }
            try 
            {
                c.close();
            } 
            catch(SQLException e) 
            {
                e.printStackTrace();
            }
        }

    }


}
