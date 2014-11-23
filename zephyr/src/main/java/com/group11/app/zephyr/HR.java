package com.group11.app.zephyr ; 
import java.util.* ;
import java.sql.*; 
import com.group11.app.zephyr.* ; 
class HR extends Student 
{
	public void registerStudent(ArrayList<Student> list, Competition cmp) 
	{
		Connection c = null;
        Statement stmt = null;
        
		try
		{
            Class.forNmae("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:common");
            stmt = c.createStatement() ; 
            for(int i=0; i<list.size(); i++)
            {
                stmt.executeQuery("insert into participants values (" + cmp.id + ", " + list.get(i).id + ") ; ") ; 
            }
		}
		catch(SQLException ex)
		{
			ex.printStackTrace() ; 
		}
        catch(ClassNotFoundException ex) {
            ex.printStackTace();
        } finally {
            try {
                c.close();
                stmt.close();                
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
	}
}
