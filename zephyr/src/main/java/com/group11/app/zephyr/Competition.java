package com.group11.app.zephyr ; 
import java.util.* ; 
import java.sql.* ; 
public class Competition extends Event implements DatabaseEntry
{
	public String name ; 
	public int id ; 
	public int rank ; 
	public String getName()
	{
		return name ; 
	}
	public Competition ( String nam, String ven, int yea, int mon, int da, int i, int rnk)
	{
		name = nam ; 
		venue = ven ; 
		year = yea ; 
		month = mon  ;				
		date = da ; 
		id = i ; 
		rank = rnk ; 
	}
	//TODO :- To be corrected.
	public ArrayList<Student> getStudent(Statement stmt) throws SQLException 
	{
		ArrayList<Student> prs = new ArrayList<Student>()  ; 
		String sql = "SELECT * FROM Competition WHERE name='" + name + "'" ; 
		String cm = "SELECT * FROM Person WHERE id=" ; 
		String sql2 = null ; 
		ResultSet rs = stmt.executeQuery(sql) ; 
		ResultSet rs2 = null ; 
		while(rs.next() == true)
		{
			System.out.println("Looping outside") ;
			sql2 = cm + rs.getInt("id") ; 
			rs2 = stmt.executeQuery(sql2) ; 
			prs.add(new Student(rs2.getInt("id"), rs2.getString("fname"), rs2.getString("lname"), rs2.getString("hostel"))) ; 	
		} 
		return prs ; 
	}

	public void putToDatabase() 
	{

		String sql = "INSERT INTO Competition (name, venue, year, month, date, id, rank) VALUES ('" + name + "','" + venue + "'," + year + "," + month + "," + date + "," + id +"," + rank + ");" ; 			
        Connection c = null;
        Statement stmt = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:/var/lib/tomcat7/webapps/zephyr/data/common");
            stmt = c.createStatement() ;
            stmt.executeUpdate(sql);
            
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
        }

	}
}
