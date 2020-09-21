package duke.exceptions;

public class DukeException extends Exception {
    String errorMessage;

    public DukeException() {
        this.errorMessage = "";
    }

    public DukeException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
