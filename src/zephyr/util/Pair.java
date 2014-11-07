class Pair
{
	Person p ; 
	int rank ; 
	public Pair(String fn, String ln, String host, String ty, int rn)
	{
		p = new Person(fn,ln,host,ty) ; 
		rank = rn ; 
	}
	public int getRank()
	{
		return rank ; 
	}
	public Person getPerson()
	{
		return p ; 
	}
}
