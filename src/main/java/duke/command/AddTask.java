package duke.command;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;

import static duke.Constants.INVALID_TASK;
import static duke.Constants.TASK_HEADER;
import static duke.Constants.FRONT_SPACING;
import static duke.Constants.NEW_LINE;
import static duke.Constants.TASK_FOOTER_FIRST_PART;
import static duke.Constants.TASK_FOOTER_SECOND_PART;

import static duke.helper.SpecialPrint.printWithLines;

public class AddTask {
    /**
     * Getting confirmation for task creation
     * */
    public static void deadlineCreator(Task newTask, ArrayList<Task> allActions) {
        allActions.add(newTask);
        String taskConfirmation = newTask.getFullTask();

        if (taskConfirmation.equals("")) {
            printWithLines(INVALID_TASK);
        } else {
            printWithLines(TASK_HEADER
                    + FRONT_SPACING + FRONT_SPACING + taskConfirmation + NEW_LINE
                    + TASK_FOOTER_FIRST_PART + allActions.size() + TASK_FOOTER_SECOND_PART);
        }
    }

    /**
     * Storing new action into Array List
     */
    public static void addAction(String command, String userInput, ArrayList<Task> allActions) {
        try {
            int firstSpaceIndex = userInput.indexOf(" ");
            String description = userInput.substring(firstSpaceIndex + 1);

//            System.out.println(firstSpaceIndex);
//            System.out.println(description);
//            System.out.println(description.length());

            if (command.equals("todo")) {
                String[] details = userInput.split(" ");
                Task newTask = new Todo(details);
                deadlineCreator(newTask, allActions);
            } else if (command.equals("deadline")) {
                String[] details = description.split(" /by ");
                Task newTask = new Deadline(details);
                deadlineCreator(newTask, allActions);
            } else if (command.equals("event")) {
                String[] details = description.split(" /at ");
                Task newTask = new Event(details);
                deadlineCreator(newTask, allActions);
            } else {
                printWithLines("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        } catch (IndexOutOfBoundsException indexError){
            printWithLines("☹ OOPS!!! The description of a " + command + " cannot be empty.");
        }
    }

}
