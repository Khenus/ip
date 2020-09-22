package duke.helper;

import duke.commands.AddCommand;
import duke.commands.Command;
import duke.commands.ListCommand;
import duke.commands.DoneCommand;
import duke.commands.DeleteCommand;
import duke.commands.PrintCommand;

import duke.exceptions.DukeException;

/**
 * Class to handle all command input by user.
 *
 * @author Khenus Tan
 */
public class Parser {
    /**
     * Command to parse inputs of user. Inputs include list, done, delete, bye, deadline, event, todo and print.
     *
     * @param command The String containing full user input
     * @return Command
     * @throws DukeException If the commands is invalid or when the needed description is missing
     */
    public static Command parse(String command) throws DukeException {
        String[] inputs = command.split(" ");

        if (inputs[0].equals("list")) {
            return new ListCommand();
        } else if (inputs[0].equals("done")) {
            return new DoneCommand(Integer.parseInt(inputs[1]));
        } else if (inputs[0].equals("delete")) {
            return new DeleteCommand(command);
        } else if (inputs[0].equals("bye") || inputs[0].equals("exit")) {
            return new Command(true);
        } else if (inputs[0].equals("todo") || inputs[0].equals("deadline") || inputs[0].equals("event")) {
            return new AddCommand(inputs[0], command);
        } else if (inputs[0].equals("print")) {
            try {
                return new PrintCommand(command);
            } catch (DukeException error) {
                throw new DukeException(error.getErrorMessage());
            }
        } else {
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
