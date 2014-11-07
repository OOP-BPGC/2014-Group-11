package zephyr;

import java.util.* ;
import zephyr.util.*;

public class Competition extends Event
{
    private ArrayList<Pair> participants = new ArrayList<Pair> () ; 
    
    public ArrayList<Pair> getPeople()
    {
        Collections.sort(participants, new CustomComparator()) ; 
        return participants ; 
    }

    
}
