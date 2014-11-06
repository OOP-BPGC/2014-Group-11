import java.util.* ; 
class Event
{
	private ArrayList<Pair> participants = new ArrayList<Pair> () ; 
	private String venue; 	
	private int year ; 
	private int month ; 
	private int date ; 
	public ArrayList<Pair> getParticipants()
	{
		Collections.sort(participants, new CustomComparator()) ; 
		return participants ; 
	}
	public int getYear()
	{
		return year ; 
	}
	public int getMonth()
	{
		return month ; 
	}
	public int getDate()
	{
		return date ; 
	}
	public void setYear(int ye)
	{
		year = ye ; 
	}
	public void setMonth(int mon)
	{
		month = mon ; 
	}
	public void setDate(int da)
	{
		date = da ; 
	}
}
