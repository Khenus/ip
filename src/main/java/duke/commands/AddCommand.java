package duke.commands;

import duke.exceptions.DukeInvalidCommandException;
import duke.exceptions.DukeDescriptionException;
import duke.exceptions.DukeDateByException;
import duke.exceptions.DukeDateAtException;
import duke.exceptions.DukeTimeFormatException;

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

public class AddCommand extends Command {
    String userInput;
    String command;

    public AddCommand(String command, String userInput) {
        this.userInput = userInput;
        this.command = command;
    }

    /**
     * Storing new action into Array ListCommand
     */
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
     * Creating new task
     */
    public static void newTaskCreator(Ui ui, String command, String userInput, TaskList allActions)
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
     * Getting confirmation for task creation
     * */
    public static void taskAddedVerification(Ui ui, Task newTask, TaskList allActions) {
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
