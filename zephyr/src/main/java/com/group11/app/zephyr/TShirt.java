package zephyr;

/* TShirt class for representing the TShirt object. */ 
public class TShirt implements DatabaseEntry 
{
	public String name ; 
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
	@Override
	public void putToDatabase()
	{
		; 
	}
}
