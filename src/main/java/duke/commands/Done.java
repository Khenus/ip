package duke.commands;

import java.util.ArrayList;

import duke.task.Task;

import static duke.Constants.INVALID_TASK_NUMBER;
import static duke.Constants.MARKED_DONE_HEADER;
import static duke.Constants.FRONT_SPACING;

import static duke.helper.SpecialPrint.printWithLines;

public class Done {
    /**
     * Update task if the value being entered is valid
     */
    public static void updateIsDone(int numberToUpdate, ArrayList<Task> allActions) {
        if (numberToUpdate > allActions.size() || numberToUpdate < 1) {
            printWithLines(INVALID_TASK_NUMBER);
        } else {
            allActions.get(numberToUpdate - 1).setIsDone(true);
            printWithLines(MARKED_DONE_HEADER
                    + FRONT_SPACING + allActions.get(numberToUpdate - 1).getFullTask());
        }
    }
}
