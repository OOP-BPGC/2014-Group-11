import java.util.* ; 
class Competition extends Event
{
	private ArrayList<Pair> participants = new ArrayList<Pair> () ; 
	private String venue; 	
	private int year ; 
	private int month ; 
	private int date ; 
	public ArrayList<Pair> getPeople()
	{
		Collections.sort(participants, new CustomComparator()) ; 
		return participants ; 
	}
}
