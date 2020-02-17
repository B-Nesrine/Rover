package Exception;

public class BadMoveException extends RuntimeException {
    public BadMoveException(String message) {
        super(message);
    }
}
