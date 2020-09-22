package duke.commands;

import duke.helper.Storage;
import duke.helper.Ui;
import duke.task.Task;
import duke.task.TaskList;

import java.util.ArrayList;

import static duke.Constants.NEW_LINE;
import static duke.Constants.FRONT_SPACING;

public class FindCommand extends Command {
    String searchString;

    public FindCommand(String searchString) {
      this.searchString = searchString;
    }

    public void execute(TaskList allActions, Ui ui, Storage storage) {
        ArrayList<Task> fullArray = allActions.getFullArray();
        ArrayList<Task> arrayToPrint = new ArrayList<>();

        for (int i = 0; i < fullArray.size(); i++) {
            String currentDescription = fullArray.get(i).getTaskDescription();

            if(currentDescription.contains(searchString)) {
                arrayToPrint.add(fullArray.get(i));
            }
        }

        printFullList(arrayToPrint, ui);
    }

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
