package pro.sky.Exception;

public class NotFoundElemException extends RuntimeException{
    public NotFoundElemException() {
    }

    public NotFoundElemException(String message) {
        super(message);
    }

    public NotFoundElemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundElemException(Throwable cause) {
        super(cause);
    }

    public NotFoundElemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
