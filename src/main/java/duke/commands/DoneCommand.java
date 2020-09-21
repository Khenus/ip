package duke.commands;

import duke.helper.Command;
import duke.task.TaskList;
import duke.helper.Ui;
import duke.helper.Storage;

import static duke.Constants.INVALID_TASK_NUMBER;
import static duke.Constants.MARKED_DONE_HEADER;
import static duke.Constants.FRONT_SPACING;

public class DoneCommand extends Command {
    int numberToUpdate;

    public DoneCommand(int numberToUpdate) {
        this.numberToUpdate = numberToUpdate;
    }

    /**
     * Update task if the value being entered is valid
     */
    public void execute(TaskList allActions, Ui ui, Storage storage) {
        if (numberToUpdate > allActions.size() || numberToUpdate < 1) {
            ui.printWithLines(INVALID_TASK_NUMBER);
        } else {
            allActions.get(numberToUpdate - 1).setIsDone(true);
            ui.printWithLines(MARKED_DONE_HEADER
                    + FRONT_SPACING + allActions.get(numberToUpdate - 1).getFullTask());
        }
    }
}
