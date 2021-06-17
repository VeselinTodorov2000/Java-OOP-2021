package exceptions;

import java.io.IOException;

public class CheckedStringTooLongException extends IOException {
    public CheckedStringTooLongException(String message) {
        super(message);
    }
}
