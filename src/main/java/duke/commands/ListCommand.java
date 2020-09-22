package duke.commands;

import duke.task.TaskList;
import duke.helper.Ui;
import duke.helper.Storage;

import static duke.Constants.FRONT_SPACING;
import static duke.Constants.LIST_HEADER;
import static duke.Constants.NEW_LINE;

public class ListCommand extends Command {
    /**
     * Listing all stored actions
     */
    public void execute(TaskList allActions, Ui ui, Storage storage) {
        String fullList = LIST_HEADER;

        for (int i = 0; i < allActions.size(); i++) {
            fullList += String.format("%s%s.%s", FRONT_SPACING, (i + 1), allActions.get(i).getFullTask());

            if (i != allActions.size() - 1) {
                fullList += NEW_LINE;
            }
        }
        ui.printWithLines(fullList);
    }
}
