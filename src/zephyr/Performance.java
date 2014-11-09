package zephyr;

public class Performance extends Event implements DatabaseEntry
{
	
    private ArrayList<Pair> participants = new ArrayList<Pair> () ;
    private String venue; 	
    private int year ; 
    private int month ; 
    private int date ; 
    public ArrayList<Student> getStudent()
    {
        /* Implement it. */ 
    }

    public void putToDatabase(Statement stmt) {

    }
}
