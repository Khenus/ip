package duke.commands;

import duke.task.TaskList;
import duke.helper.Ui;
import duke.helper.Storage;
import duke.exceptions.DukeItemNumberException;
import duke.exceptions.DukeDescriptionNumberException;
import duke.exceptions.DukeDescriptionOutOfBoundException;

import static duke.helper.CheckNumeric.isNumeric;

import static java.lang.Integer.parseInt;

import static duke.Constants.NEW_LINE;
import static duke.Constants.FRONT_SPACING;
import static duke.Constants.DELETION_HEADER;
import static duke.Constants.NOT_NUMBER_DELETION;
import static duke.Constants.INVALID_TASK_NUMBER;
import static duke.Constants.OUT_OF_BOUND_DELETION;
import static duke.Constants.CONFIRMATION_FOOTER_FIRST_PART;
import static duke.Constants.CONFIRMATION_FOOTER_SECOND_PART;

/**
 * A class to handle all deletion command
 *
 * @author Khenus Tan
 */
public class DeleteCommand extends Command {
    private String userInput;

    /**
     * Constructor for deletion command
     *
     * @param userInput The string of full user input i.e event [description] /at [date] [time]
     */
    public DeleteCommand(String userInput) {
        this.userInput = userInput;
    }

    /**
     * Execute command for deleting a specific entry from TaskList. Captures exception for invalid item
     * number for deletion, input that is not a number and number that is larger than the TaskList provided
     *
     * @param task The TaskList containing all added tasks
     * @param ui The Ui for interfacing with the user
     * @param storage The Storage for file IO
     */
    @Override
    public void execute(TaskList task, Ui ui, Storage storage) {
        try {
            deletionHandler(userInput, task, ui);
        } catch (DukeItemNumberException itemNumberError) {
            ui.printWithLines(INVALID_TASK_NUMBER);
        } catch (DukeDescriptionNumberException notANumberError) {
            ui.printWithLines(NOT_NUMBER_DELETION);
        } catch (DukeDescriptionOutOfBoundException numberExceededError) {
            ui.printWithLines(OUT_OF_BOUND_DELETION);
        }
    }

    /**
     * Helper function to execute the deletion of task from TaskList if input is valid
     *
     * @param userInput
     * @param allActions
     * @param ui
     *
     * @throws DukeItemNumberException If user did not input a number to be deleted
     * @throws DukeDescriptionNumberException If user input an index that is not a number
     * @throws DukeDescriptionOutOfBoundException If user input an index that is larger than the size of TaskList
     */
    private void deletionHandler(String userInput, TaskList allActions, Ui ui)
            throws DukeItemNumberException, DukeDescriptionNumberException, DukeDescriptionOutOfBoundException {
        String[] userInputs= userInput.split(" ");

        if (userInputs.length < 2) {
            throw new DukeItemNumberException();
        } else if (!isNumeric(userInputs[1])) {
            throw new DukeDescriptionNumberException();
        } else if (allActions.size() < parseInt(userInputs[1])) {
            throw new DukeDescriptionOutOfBoundException();
        } else {
            int indexToRemove = parseInt(userInputs[1]) - 1;
            String deletionConfirmation = allActions.get(indexToRemove).getFullTask();

            allActions.remove(indexToRemove);

            ui.printWithLines(DELETION_HEADER
                    + FRONT_SPACING + FRONT_SPACING + deletionConfirmation + NEW_LINE
                    + CONFIRMATION_FOOTER_FIRST_PART + allActions.size() + CONFIRMATION_FOOTER_SECOND_PART);
        }
    }
}
