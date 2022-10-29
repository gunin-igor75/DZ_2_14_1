package pro.sky.Exception;

public class ArrayListErrorException extends RuntimeException{
    public ArrayListErrorException() {
    }

    public ArrayListErrorException(String message) {
        super(message);
    }

    public ArrayListErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayListErrorException(Throwable cause) {
        super(cause);
    }

    public ArrayListErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
