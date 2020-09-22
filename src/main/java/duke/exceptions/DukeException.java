package duke.exceptions;

/**
 * An Exception for all errors in Duke
 */
public class DukeException extends Exception {
    private String errorMessage;

    /**
     * A constructor for Duke Exception class
     */
    public DukeException() {
        this.errorMessage = "";
    }

    /**
     * An alternative constructor for Duke Exception class
     *
     * @param errorMessage The String containing error message to be shown
     */
    public DukeException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * A function to get error message stored within this exception
     *
     * @return String
     */
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
