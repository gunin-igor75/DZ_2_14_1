package pro.sky.Exception;

public class NotFoundArrayListException extends RuntimeException{
    public NotFoundArrayListException() {
    }

    public NotFoundArrayListException(String message) {
        super(message);
    }

    public NotFoundArrayListException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundArrayListException(Throwable cause) {
        super(cause);
    }

    public NotFoundArrayListException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
