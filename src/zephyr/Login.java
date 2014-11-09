package zephyr;

import zephyr.util.*

public class Login {
    Student s; // can be both Student as well as HR. Ha! Power of polymorphism

    public Login(Student s) {        
        this.s = s;
    }

    public boolean checkCredentials() {
        // will call Utility class to get the job done
        // checks whether s.password and s.id match with the database.
    }
}
