package duke.helper;

import java.util.Scanner;

import static duke.Constants.TOP_LINE;
import static duke.Constants.INITIALIZER;
import static duke.Constants.SAVING_INFO;
import static duke.Constants.BOTTOM_LINE;
import static duke.Constants.BYE_HEADER;
import static duke.Constants.GREETING_HEADER_TOP;
import static duke.Constants.GREETING_HEADER_BOTTOM;

/**
 * Class to handle user interfacing
 *
 * @author Khenus Tan
 */
public class Ui {
    private Scanner scanner;

    /**
     * Constructor for UI class
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * A function to show the error codes
     *
     * @param error The error String
     */
    public void showError(String error) {
        printWithLines(error);
    }

    /**
     * A function to show the welcome message
     */
    public void showWelcome() {
        printWithLines(GREETING_HEADER_TOP + GREETING_HEADER_BOTTOM);
    }

    /**
     * A function to show the goodbye message
     */
    public void showGoodbye() {
        printWithLines(BYE_HEADER);
    }

    /**
     * A function to read in the command input of the user
     *
     * @return String
     */
    public String readCommand() {
        return scanner.nextLine().toLowerCase();
    }

    /**
     * A function to print information with bounding lines
     *
     * @param stringToPrint The String containing the string to be printed
     */
    public static void printWithLines(String stringToPrint) {
        String finalString = TOP_LINE + stringToPrint + BOTTOM_LINE;
        System.out.println(finalString);
    }

    /**
     * A function to print the initialising message
     *
     * @param stringToPrint The String containing the string to be printed
     */
    public static void printInitializer(String stringToPrint) {
        String finalString = TOP_LINE + INITIALIZER + stringToPrint + SAVING_INFO;
        System.out.println(finalString);
    }
}
