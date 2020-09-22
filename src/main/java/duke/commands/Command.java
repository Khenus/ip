package duke.commands;

import duke.helper.Storage;
import duke.helper.Ui;
import duke.task.TaskList;

public class Command {
    boolean isExit = false;

    public Command() {}

    public Command(boolean isExit) {
        this.isExit = isExit;
    }

    public boolean isExit() {
        return this.isExit;
    }

    public void execute(TaskList task, Ui ui, Storage storage) {};
}
