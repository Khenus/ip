package duke.commands;

import duke.task.TaskList;
import duke.helper.Ui;
import duke.helper.Storage;

import static duke.Constants.FRONT_SPACING;
import static duke.Constants.LIST_HEADER;
import static duke.Constants.NEW_LINE;

/**
 * A class to handle List command
 *
 * @author Khenus Tan
 */
public class ListCommand extends Command {
    /**
     * Execute command for listing all task inside a TaskList.
     *
     * @param allActions The TaskList containing all added tasks
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
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
