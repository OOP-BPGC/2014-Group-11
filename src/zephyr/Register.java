package zephyr;

public class Register {
    Student s;

    public Register(Student s) {
        this.s = s;
    }

    private boolean checkIfAlreadyPresent() {
        // checks if given student object is already present;
    }

    public void registerStudent() {
        // inserts the given student into the db if validated by checkIfAlreadyPresent;
    }
}
