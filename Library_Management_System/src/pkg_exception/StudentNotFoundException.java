package pkg_exception;

import java.io.Serial;

@SuppressWarnings("ALL")
public class StudentNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public StudentNotFoundException() {
        super();
    }

    @Override
    public String toString() {
        return "StudentNotFoundException is Generated";
    }

}
