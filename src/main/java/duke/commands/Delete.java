package duke.commands;

import duke.task.Task;
import duke.exceptions.DukeItemNumberException;
import duke.exceptions.DukeDescriptionNumberException;
import duke.exceptions.DukeDescriptionOutOfBoundException;

import static duke.helper.CheckNumeric.isNumeric;
import static duke.helper.SpecialPrint.printWithLines;

import java.util.ArrayList;
import static java.lang.Integer.parseInt;

import static duke.Constants.NEW_LINE;
import static duke.Constants.FRONT_SPACING;
import static duke.Constants.DELETION_HEADER;
import static duke.Constants.NOT_NUMBER_DELETION;
import static duke.Constants.INVALID_TASK_NUMBER;
import static duke.Constants.OUT_OF_BOUND_DELETION;
import static duke.Constants.CONFIRMATION_FOOTER_FIRST_PART;
import static duke.Constants.CONFIRMATION_FOOTER_SECOND_PART;

public class Delete{
    public static void deleteTask(String userInput, ArrayList<Task> allActions) {
        try {
            deletionHandler(userInput, allActions);
        } catch (DukeItemNumberException itemNumberError) {
            printWithLines(INVALID_TASK_NUMBER);
        } catch (DukeDescriptionNumberException notANumberError) {
            printWithLines(NOT_NUMBER_DELETION);
        } catch (DukeDescriptionOutOfBoundException numberExceededError) {
            printWithLines(OUT_OF_BOUND_DELETION);
        }
    }

    public static void deletionHandler(String userInput, ArrayList<Task> allActions)
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

            printWithLines(DELETION_HEADER
                    + FRONT_SPACING + FRONT_SPACING + deletionConfirmation + NEW_LINE
                    + CONFIRMATION_FOOTER_FIRST_PART + allActions.size() + CONFIRMATION_FOOTER_SECOND_PART);
        }
    }
}
