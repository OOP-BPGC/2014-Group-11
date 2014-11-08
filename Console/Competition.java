import java.util.* ; 
import java.sql.* ; 
class Competition extends Event  
{
	private String venue; 	
	private String name ; 
	private int year ; 
	private int month ; 
	private int date ; 
	private int id ; 
	private int rank ; 
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
	public ArrayList<Person> getPeople(Statement stmt) throws SQLException 
	{
		ArrayList<Person> prs = new ArrayList<Person>()  ; 
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
			prs.add(new Person(rs2.getInt("id"), rs2.getString("fname"), rs2.getString("lname"), rs2.getString("hostel"))) ; 	
		} 
		return prs ; 
	}
	public void writeToDataBase(Statement stmt) throws SQLException 
	{
		String sql = "INSERT INTO Competition (name, venue, year, month, date, id, rank) VALUES ('" + name + "','" + venue + "'," + year + "," + month + "," + date + "," + id +"," + rank + ");" ; 	
		stmt.executeUpdate(sql) ; 
	}
}
