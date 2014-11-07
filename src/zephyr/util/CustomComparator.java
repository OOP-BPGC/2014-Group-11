import java.util.* ; 
class CustomComparator implements Comparator<Pair> 
{
	@Override 
	public int compare(Pair p1, Pair p2)
	{
		if(p1.getRank() < p2.getRank())
			return 1 ; 
		else
			return 0 ; 
	}
}
