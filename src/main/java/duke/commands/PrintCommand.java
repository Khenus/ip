package duke.commands;

import duke.exceptions.*;
import duke.helper.Storage;
import duke.helper.Ui;
import duke.task.Task;
import duke.task.Event;
import duke.task.Todo;
import duke.task.Deadline;
import duke.task.TaskList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import static duke.Constants.DATE_FORMAT_ERROR;
import static duke.Constants.FRONT_SPACING;
import static duke.Constants.NEW_LINE;

/**
 * A class to handle Search by date command
 *
 * @author Khenus Tan
 */
public class PrintCommand extends Command {
    private String sortBy;
    private LocalDate dateToSearch;

    /**
     * Constructor for search by date command
     *
     * @param command The full input of user
     *
     * @throws DukeException If the search date is missing or if the date is in the wrong format
     */
    public PrintCommand(String command) throws DukeException {
        String[] information = command.split(" ");
        this.sortBy = information[1].toLowerCase();

        if (sortBy.equals("todo")) {
            dateToSearch = null;
        } else {
            try {
                System.out.println(information[2]);
                this.dateToSearch = LocalDate.parse(information[2]);
            } catch (DateTimeParseException dateFormatError) {
                throw new DukeException(DATE_FORMAT_ERROR);
            } catch (IndexOutOfBoundsException indexMissing) {
                throw new DukeException("The search date is missing!");
            }
        }
    }

    /**
     * Execute for searching for deadline or event that is due on a specific date
     *
     * @param allActions The TaskList containing all added tasks
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    public void execute(TaskList allActions, Ui ui, Storage storage) {
        if (sortBy.equals("deadline") || sortBy.equals("event")) {
            ArrayList<Task> fullArray = allActions.getFullArray();
            ArrayList<Task> arrayToPrint = new ArrayList<>();

            for (int i = 0; i < fullArray.size(); i++) {
                Task currentTask = fullArray.get(i);

                if (sortBy.equals("deadline") && currentTask instanceof Deadline) {
                    Deadline deadline = (Deadline) currentTask;

                    if (dateToSearch.equals(deadline.getDateBy())) {
                        arrayToPrint.add(deadline);
                    }
                } else if (sortBy.equals("event") && currentTask instanceof Event) {
                    Event event = (Event) currentTask;

                    if (dateToSearch.equals(event.getDateAt())) {
                        arrayToPrint.add(event);
                    }
                }
            }

            printFullList(arrayToPrint, ui);
        } else if (sortBy.equals("todo")) {
            ArrayList<Task> fullArray = allActions.getFullArray();
            ArrayList<Task> arrayToPrint = new ArrayList<>();

            for (int i = 0; i < fullArray.size(); i++) {
                Task currentTask = fullArray.get(i);

                if (currentTask instanceof Todo) {
                    arrayToPrint.add(currentTask);
                }
            }

            printFullList(arrayToPrint, ui);
        } else {
            ui.printWithLines(FRONT_SPACING + "Sorry, the type of task must be Deadline, Event or Todo!");
        }
    }

    /**
     * Helper function to print the full list of array that contains the search result
     *
     * @param arrayToPrint The ArrayList containing all search result
     * @param ui The Ui for interfacing with the user
     */
    private void printFullList(ArrayList<Task> arrayToPrint, Ui ui) {
        if (sortBy.equals("todo")) {
            if (arrayToPrint.size() == 0) {
                ui.printWithLines(FRONT_SPACING + "There are no currently no "
                        + sortBy + "s.");
            } else {
                String toPrint = FRONT_SPACING + "The "
                        + sortBy + "s are:\n";

                for (Task currentTask : arrayToPrint) {
                    toPrint += FRONT_SPACING + "• " + currentTask.getFullTask() + NEW_LINE;
                }

                toPrint += FRONT_SPACING + "Number of " + sortBy + "s = " + arrayToPrint.size();
                ui.printWithLines(toPrint);
            }
        } else {
            if (arrayToPrint.size() == 0) {
                ui.printWithLines(FRONT_SPACING + "There are no currently no "
                        + sortBy
                        + "s on "
                        + dateToSearch.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
            } else {
                String toPrint = FRONT_SPACING + "The "
                        + sortBy
                        + "s on "
                        + dateToSearch.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " are:\n";

                for (Task currentTask : arrayToPrint) {
                    toPrint += FRONT_SPACING + "• " + currentTask.getFullTask() + NEW_LINE;
                }

                toPrint += FRONT_SPACING + "Number of " + sortBy + "s = " + arrayToPrint.size();
                ui.printWithLines(toPrint);
            }
        }
    }
}
