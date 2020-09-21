package duke.helper;

import java.util.Scanner;

import static duke.Constants.TOP_LINE;
import static duke.Constants.INITIALIZER;
import static duke.Constants.SAVING_INFO;
import static duke.Constants.BOTTOM_LINE;
import static duke.Constants.BYE_HEADER;
import static duke.Constants.GREETING_HEADER_TOP;
import static duke.Constants.GREETING_HEADER_BOTTOM;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void showError(String error) {
        printWithLines(error);
    }

    public void showLine() {
        System.out.print(TOP_LINE);
    }

    public void showWelcome() {
        printWithLines(GREETING_HEADER_TOP + GREETING_HEADER_BOTTOM);
    }

    public void showGoodbye() {
        printWithLines(BYE_HEADER);
    }

    public String readCommand() {
        return scanner.nextLine().toLowerCase();
    }

    /**
     * Printing information within bounding lines
     */
    public static void printWithLines(String stringToPrint) {
        String finalString = TOP_LINE + stringToPrint + BOTTOM_LINE;
        System.out.println(finalString);
    }

    public static void printInitializer(String stringToPrint) {
        String finalString = TOP_LINE + INITIALIZER + stringToPrint + SAVING_INFO;
        System.out.println(finalString);
    }
}
