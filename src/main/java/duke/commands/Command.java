package duke.commands;

import duke.helper.Storage;
import duke.helper.Ui;
import duke.task.TaskList;

/**
 * Parent class for all Commands in Duke
 *
 * @author Khenus Tan
 * */
public class Command {
    private boolean isExit;

    /**
     * Default constructor for Command Classes
     * */
    public Command() {
        this.isExit = false;
    }

    /**
     * Overloaded constructor to handle checking of whether the program
     * have been terminated
     *
     * @param isExit The boolean value of whether the program is terminated
     * */
    public Command(boolean isExit) {
        this.isExit = isExit;
    }

    /**
     * Getter for whether the program have exited
     *
     * @return boolean
     * */
    public boolean isExit() {
        return this.isExit;
    }

    /**
     * Default execute function for all child classes
     *
     * @param task The TaskList containing all added tasks
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     * */
    public void execute(TaskList task, Ui ui, Storage storage) {};
}
