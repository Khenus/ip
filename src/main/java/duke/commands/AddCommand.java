package duke.commands;

import duke.exceptions.*;
import duke.task.TaskList;
import duke.helper.Ui;
import duke.helper.Storage;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import static duke.Constants.INVALID_TASK;
import static duke.Constants.TASK_HEADER;
import static duke.Constants.FRONT_SPACING;
import static duke.Constants.NEW_LINE;
import static duke.Constants.DATE_FORMAT_ERROR;
import static duke.Constants.CONFIRMATION_FOOTER_FIRST_PART;
import static duke.Constants.CONFIRMATION_FOOTER_SECOND_PART;


/**
 * Class to handle creation and addition of a new Todo, Event or DeadLine task to TaskList.
 * Inherits from {@link Command}
 *
 * @author Khenus Tan
 * */
public class AddCommand extends Command {
    private String userInput;
    private String command;

    /**
     * Constructor for AddCommand class
     *
     * @param command The command string
     * @param userInput The string of full user input i.e event [description] /at [date] [time]
     * */
    public AddCommand(String command, String userInput) {
        this.userInput = userInput;
        this.command = command;
    }

    /**
     * Execute command for adding a new Task into list. This also captures exception if the command is
     * invalid, missing description, missing date for deadline and events
     *
     * @param allActions The TaskList containing all added tasks
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
    public void execute(TaskList allActions, Ui ui, Storage storage) {
        try {
            newTaskCreator(ui, command, userInput, allActions);
        } catch (DukeInvalidCommandException commandError){
            ui.printWithLines("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        } catch (DukeDescriptionException descriptionError) {
            ui.printWithLines("☹ OOPS!!! The description of a " + command + " cannot be empty.");
        } catch (DukeDateByException dateByError) {
            ui.printWithLines("☹ OOPS!!! The date by of a deadline cannot be empty.");
        } catch (DukeDateAtException dateAtError) {
            ui.printWithLines("☹ OOPS!!! The date at of an event cannot be empty.");
        }
    }

    /**
     * Helper function to create a new Task object, before storing it into TaskList if there is no error
     *
     * @param ui The Ui for interfacing with the user
     * @param command The command string input by the user
     * @param userInput The String containing full user input i.e todo description
     * @param allActions The TaskList containing all added tasks
     *
     * @throws DukeDescriptionException If the description is empty
     * @throws DukeDateAtException If the date at for an event is empty
     * @throws DukeDateByException If the date by for a deadline is empty
     * @throws DukeInvalidCommandException If the command being entered is invalid
     */
    private void newTaskCreator(Ui ui, String command, String userInput, TaskList allActions)
            throws DukeDescriptionException, DukeDateAtException, DukeDateByException, DukeInvalidCommandException {
        int firstSpaceIndex = userInput.indexOf(" ");
        String description = userInput.substring(firstSpaceIndex + 1);

        if (!command.equals("todo") && !command.equals("deadline") && !command.equals("event")) {
            throw new DukeInvalidCommandException();
        }

        if (description.length() == 0 || firstSpaceIndex == -1) {
            throw new DukeDescriptionException();
        }

        if (command.equals("todo")) {
            Task newTask = new Todo(description);

            description = description.trim();
            if (description == "") {
                throw new DukeDescriptionException();
            }

            allActions.add(newTask);
            taskAddedVerification(ui, newTask, allActions);
        } else if (command.equals("deadline")) {
            String[] details = description.split(" /by ");

            if (details.length < 2) {
                throw new DukeDateByException();
            }

            details[1] = details[1].trim();
            if (details[1] == "") {
                throw new DukeDateAtException();
            }

            try {
                Task newTask = new Deadline(details);
                allActions.add(newTask);
                taskAddedVerification(ui, newTask, allActions);
            } catch (DukeTimeFormatException timeFormatError) {
                ui.printWithLines(DATE_FORMAT_ERROR);
            }
        } else if (command.equals("event")) {
            String[] details = description.split(" /at ");
            if (details.length < 2) {
                throw new DukeDateAtException();
            }

            details[1] = details[1].trim();
            if (details[1] == "") {
                throw new DukeDateAtException();
            }

            try {
                Task newTask = new Event(details);
                allActions.add(newTask);
                taskAddedVerification(ui, newTask, allActions);
            } catch (DukeTimeFormatException timeFormatError) {
                ui.printWithLines(DATE_FORMAT_ERROR);
            }
        }
    }

    /**
     * Helper function to get verification if a new Task is successfully created
     *
     * @param ui The Ui for interfacing with the user
     * @param allActions The TaskList containing all added tasks
     * @param newTask The new Task that is added
     * */
    private void taskAddedVerification(Ui ui, Task newTask, TaskList allActions) {
        String taskConfirmation = newTask.getFullTask();

        if (taskConfirmation.equals("")) {
            ui.printWithLines(INVALID_TASK);
        } else {
            ui.printWithLines(TASK_HEADER
                    + FRONT_SPACING + FRONT_SPACING + taskConfirmation + NEW_LINE
                    + CONFIRMATION_FOOTER_FIRST_PART + allActions.size() + CONFIRMATION_FOOTER_SECOND_PART);
        }
    }
}
