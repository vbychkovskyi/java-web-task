package ua.bychkovskyy.errors;

public class OperationNotFoundException extends Exception {
    public OperationNotFoundException(String operation) {
        super("Operation " + operation + " not found or not supported");
    }
}
