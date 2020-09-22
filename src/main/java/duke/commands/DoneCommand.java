package duke.commands;

import duke.task.TaskList;
import duke.helper.Ui;
import duke.helper.Storage;

import static duke.Constants.INVALID_TASK_NUMBER;
import static duke.Constants.MARKED_DONE_HEADER;
import static duke.Constants.FRONT_SPACING;

/**
 * A class to handle all "Mark as done" command
 *
 * @author Khenus Tan
 */
public class DoneCommand extends Command {
    private int numberToUpdate;

    /**
     * Constructor for the command "Done"
     *
     * @param numberToUpdate The index of the task to be "Mark as done"
     */
    public DoneCommand(int numberToUpdate) {
        this.numberToUpdate = numberToUpdate;
    }

    /**
     * Execute command for marking a certain task from TaskList as done. Checks for whether input exist
     * within the size of the TaskList.
     *
     * @param allActions The TaskList containing all added tasks
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
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
