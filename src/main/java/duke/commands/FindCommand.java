package duke.commands;

import duke.helper.Storage;
import duke.helper.Ui;
import duke.task.Task;
import duke.task.TaskList;

import java.util.ArrayList;

import static duke.Constants.FRONT_SPACING;
import static duke.Constants.NEW_LINE;

/**
 * A class to handle all find command
 *
 * @author Khenus Tan
 */
public class FindCommand extends Command {
    private String searchString;

    /**
     * Constructor for find command
     *
     * @param searchString A String containing the keyword to be searched for
     */
    public FindCommand(String searchString) {
      this.searchString = searchString.toLowerCase();
    }

    /**
     * Execute command for finding a keyword from the Tasks inside a task list before
     * printing the result
     *
     * @param allActions The TaskList containing all added tasks
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    public void execute(TaskList allActions, Ui ui, Storage storage) {
        ArrayList<Task> fullArray = allActions.getFullArray();
        ArrayList<Task> arrayToPrint = new ArrayList<>();

        for (int i = 0; i < fullArray.size(); i++) {
            String currentDescription = fullArray.get(i).getTaskDescription();

            if(currentDescription.toLowerCase().contains(searchString)) {
                arrayToPrint.add(fullArray.get(i));
            }
        }

        printFullList(arrayToPrint, ui);
    }

    /**
     * Helper function to print the result of the search
     *
     * @param arrayToPrint The ArrayList containing the result of the search
     * @param ui The UI to interface with the user
     */
    private void printFullList(ArrayList<Task> arrayToPrint, Ui ui) {
        if (arrayToPrint.size() == 0) {
            ui.printWithLines(FRONT_SPACING + "There are no matching tasks in your list.");
        } else {
            String toPrint = FRONT_SPACING + "Here are the matching tasks in your list:\n";

            for (int i = 0; i < arrayToPrint.size(); i++) {
                int point = i + 1;
                toPrint += FRONT_SPACING + point + "." + arrayToPrint.get(i).getFullTask();

                if (i != arrayToPrint.size() - 1) {
                    toPrint += NEW_LINE;
                }
            }

            ui.printWithLines(toPrint);
        }
    }
}
