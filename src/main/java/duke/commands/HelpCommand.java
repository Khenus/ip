package duke.commands;

import duke.helper.Storage;
import duke.helper.Ui;
import duke.task.TaskList;

import static duke.Constants.AVAILABLE_COMMANDS;

/**
 * A class to handle all help command
 *
 * @author Khenus Tan
 */
public class HelpCommand extends Command {
    /**
     * Execute help command
     *
     * @param allActions The TaskList containing all added tasks
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
    public void execute(TaskList allActions, Ui ui, Storage storage) {
        ui.printWithLines(AVAILABLE_COMMANDS);
    }
}
