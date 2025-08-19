package pkg_exception;

import java.io.Serial;

@SuppressWarnings("ALL")
public class BookNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public BookNotFoundException() {

    }
    public String toString() {
        return "BookNotFoundException is Generated";
    }

}
