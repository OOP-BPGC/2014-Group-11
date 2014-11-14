package com.group11.app.zephyr;
import java.sql.*; 

public class Pass implements DatabaseEntry
{
    int id ;
    Performance perf ;

	@Override
    public void putToDatabase(Statement stmt)
	{

    }
}
