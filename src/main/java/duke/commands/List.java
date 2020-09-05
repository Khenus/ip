package duke.commands;

import duke.task.Task;

import java.util.ArrayList;

import static duke.Constants.FRONT_SPACING;
import static duke.Constants.LIST_HEADER;
import static duke.Constants.NEW_LINE;

import static duke.helper.SpecialPrint.printWithLines;

public class List {
    /**
     * Listing all stored actions
     */
    public static void listAllActions(ArrayList<Task> allActions) {
        String fullList = LIST_HEADER;

        for (int i = 0; i < allActions.size(); i++) {
            fullList += String.format("%s%s.%s", FRONT_SPACING, (i + 1), allActions.get(i).getFullTask());

            if (i != allActions.size() - 1) {
                fullList += NEW_LINE;
            }
        }
        printWithLines(fullList);
    }
}
