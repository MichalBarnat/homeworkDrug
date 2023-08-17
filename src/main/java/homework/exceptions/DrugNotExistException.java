package homework.exceptions;

public class DrugNotExistException extends RuntimeException {
    public DrugNotExistException() {
    }

    public DrugNotExistException(String message) {
        super(message);
    }
}
