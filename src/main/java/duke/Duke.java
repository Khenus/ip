package duke;

import duke.exceptions.DukeException;
import duke.commands.Command;
import duke.helper.Parser;
import duke.helper.Storage;
import duke.helper.Ui;
import duke.task.TaskList;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

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
            } finally {
            }
        }
        ui.showGoodbye();
    }

    public static void main(String[] args) {
        new Duke("tasks.txt").run();
    }
}