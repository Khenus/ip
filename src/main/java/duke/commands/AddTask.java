package duke.commands;

import duke.exceptions.DukeDateAtException;
import duke.exceptions.DukeDateByException;
import duke.exceptions.DukeDescriptionException;
import duke.exceptions.DukeInvalidCommandException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;

import static duke.Constants.INVALID_TASK;
import static duke.Constants.TASK_HEADER;
import static duke.Constants.FRONT_SPACING;
import static duke.Constants.NEW_LINE;
import static duke.Constants.CONFIRMATION_FOOTER_FIRST_PART;
import static duke.Constants.CONFIRMATION_FOOTER_SECOND_PART;

import static duke.helper.SpecialPrint.printWithLines;

public class AddTask {
    /**
     * Storing new action into Array List
     */
    public static void addAction(String command, String userInput, ArrayList<Task> allActions) {
        try {
            newTaskCreator(command, userInput, allActions);
        } catch (DukeInvalidCommandException commandError){
            printWithLines("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        } catch (DukeDescriptionException descriptionError) {
            printWithLines("☹ OOPS!!! The description of a " + command + " cannot be empty.");
        } catch (DukeDateByException dateByError) {
            printWithLines("☹ OOPS!!! The date by of a deadline cannot be empty.");
        } catch (DukeDateAtException dateAtError) {
            printWithLines("☹ OOPS!!! The date at of an event cannot be empty.");
        }
    }

    /**
     * Creating new task
     */
    public static void newTaskCreator(String command, String userInput, ArrayList<Task> allActions)
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
            taskAddedVerification(newTask, allActions);
        } else if (command.equals("deadline")) {
            String[] details = description.split(" /by ");

            if (details.length < 2) {
                throw new DukeDateByException();
            }

            details[1] = details[1].trim();
            if (details[1] == "") {
                throw new DukeDateAtException();
            }

            Task newTask = new Deadline(details);
            allActions.add(newTask);
            taskAddedVerification(newTask, allActions);
        } else if (command.equals("event")) {
            String[] details = description.split(" /at ");
            if (details.length < 2) {
                throw new DukeDateAtException();
            }

            details[1] = details[1].trim();
            if (details[1] == "") {
                throw new DukeDateAtException();
            }

            Task newTask = new Event(details);
            allActions.add(newTask);
            taskAddedVerification(newTask, allActions);
        }
    }

    /**
     * Getting confirmation for task creation
     * */
    public static void taskAddedVerification(Task newTask, ArrayList<Task> allActions) {
        String taskConfirmation = newTask.getFullTask();

        if (taskConfirmation.equals("")) {
            printWithLines(INVALID_TASK);
        } else {
            printWithLines(TASK_HEADER
                    + FRONT_SPACING + FRONT_SPACING + taskConfirmation + NEW_LINE
                    + CONFIRMATION_FOOTER_FIRST_PART + allActions.size() + CONFIRMATION_FOOTER_SECOND_PART);
        }
    }
}
