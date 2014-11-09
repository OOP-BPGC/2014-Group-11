package zephyr;

public class Pass implements DatabaseEntry
{
    int id ;
    Performance perf ;

    public Pass(id, perf) {
        this.id = id;
        this.perf = perf;
    }
    
    public void putToDatabase(Statement stmt){

    }
}
