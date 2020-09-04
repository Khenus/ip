package duke.helper;

import static duke.Constants.BOTTOM_LINE;
import static duke.Constants.TOP_LINE;

public class SpecialPrint {
    /**
     * Printing information within bounding lines
     */
    public static void printWithLines(String stringToPrint) {
        String finalString = TOP_LINE + stringToPrint + BOTTOM_LINE;
        System.out.println(finalString);
    }
}
