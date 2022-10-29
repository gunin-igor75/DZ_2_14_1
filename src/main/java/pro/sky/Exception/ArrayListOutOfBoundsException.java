package pro.sky.Exception;

public class ArrayListOutOfBoundsException extends RuntimeException{
    public ArrayListOutOfBoundsException() {
    }

    public ArrayListOutOfBoundsException(String message) {
        super(message);
    }

    public ArrayListOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayListOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    public ArrayListOutOfBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
