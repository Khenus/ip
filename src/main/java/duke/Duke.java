package duke;

import duke.exceptions.DukeException;
import duke.commands.Command;
import duke.helper.Parser;
import duke.helper.Storage;
import duke.helper.Ui;
import duke.task.TaskList;

/**
 * Main class for Duke
 *
 * @author Khenus Tan
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructor for Duke to allow for initialising of save files
     *
     * @param filePath A String containing the path of the save file
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showError(e.getErrorMessage());
            tasks = new TaskList();
        }
    }

    /**
     * A continuously running function to allow for user input and task operations
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
                storage.write(tasks);
            } catch (DukeException e) {
                ui.showError(e.getErrorMessage());
            }
        }
        ui.showGoodbye();
    }

    /**
     * Main function of project Duke
     *
     * @param args A String Array containing arguments when running Duke
     */
    public static void main(String[] args) {
        new Duke("tasks.txt").run();
    }
}