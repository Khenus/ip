package duke.helper;

import static duke.Constants.TOP_LINE;
import static duke.Constants.BOTTOM_LINE;
import static duke.Constants.INITIALIZER;
import static duke.Constants.SAVING_INFO;

public class SpecialPrint {
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
