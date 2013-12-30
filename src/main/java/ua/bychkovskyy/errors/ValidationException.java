package ua.bychkovskyy.errors;

public class ValidationException extends Exception {

    private String message;

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ValidationException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
