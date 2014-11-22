package com.group11.app.zephyr;

import java.sql.* ; 

/* TShirt class for representing the TShirt object. */ 
public class TShirt implements DatabaseEntry 
{
    public String name ; 
    public String path ; 
    public int id; 
    public int qs ; 
    public int ql ; 
    public int qm ; 
    public int qxl  ;

    public TShirt(String n, int i, int s, int m, int l, int xl) 
    {
        name = n ; 
        id = i ; 
        qs = s ; 
        qm = m ;
        ql = l ; 
        qxl = xl ; 
        // ; 
    } 
    public TShirt(String n, String p, int i)
    {
        name = n ; 
        path = p ; 
        id = i ; 
    }
    @Override
    public void putToDatabase() 
    {
        Connection c = null;
        Statement stmt = null;
        
        try 
	{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/var/lib/tomcat7/webapps/zephyr/data/common");
            stmt = c.createStatement() ;

            stmt.executeUpdate("INSERT INTO tshirt VALUES(\"" + name + "\", \""+path + "\", " + id + ")") ; 	            

        } 
	catch(SQLException e) 
	{

            e.printStackTrace();            
            
        } 
	catch(ClassNotFoundException e)
	{
		e.printStackTrace() ; 
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
    public void putToDatabase(Statement stmt) 
    {
        try 
	{
            stmt.executeUpdate("INSERT INTO tshirt VALUES(\"" + name + "\", \""+path + "\", " + id + ")") ; 	            

        } 
	catch(SQLException e) 
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
        }                        
    }

    public static int getNoTShirts() {
        Connection c = null;
        Statement stmt = null;
        int norows = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/var/lib/tomcat7/webapps/zephyr/data/common");
            stmt = c.createStatement() ;

            ResultSet rs = stmt.executeQuery("SELECT count(*) as rowcount FROM tshirt;");
            norows = rs.getInt("rowcount");

        } catch(SQLException e) {
            e.printStackTrace();            
            
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            
        } finally {
            try {
                stmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
            try {
                c.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }

            return norows;
        }

    }
}
