package zephyr;

/* TShirt class for representing the TShirt object. */ 
public class TShirt implements DatabaseEntry 
{
    private String name ; 
    private int id; 
    int qs ; 
    int ql ; 
    int qm ; 
    int qxl  ;
    int qxxl ;
    
    public TShirt(String n, int s, int m, int l, int xl, int xxl) 
    {
        // ; 
    } 
    public void putToDataBase(Statement stmt)
    {
        
    }
}
