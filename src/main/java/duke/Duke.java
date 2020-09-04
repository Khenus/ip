package duke;

import duke.task.Task;

import java.util.Scanner;
import java.util.ArrayList;

import static duke.Constants.BYE_HEADER;
import static duke.Constants.GREETING_HEADER_TOP;
import static duke.Constants.GREETING_HEADER_BOTTOM;

import static duke.command.Done.updateIsDone;
import static duke.command.AddTask.addAction;
import static duke.helper.SpecialPrint.printWithLines;
import static duke.command.List.listAllActions;

public class Duke {
    public static ArrayList<Task> allActions = new ArrayList<>();

    public static void main(String[] args) {
        printWithLines(GREETING_HEADER_TOP + GREETING_HEADER_BOTTOM);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String inputInLowerCase = input.toLowerCase();

        while (!inputInLowerCase.equals("bye")) {
            String[] inputs = inputInLowerCase.split(" ");

            if (inputs[0].equals("list")) {
                listAllActions(allActions);
            } else if (inputs[0].equals("done")) {
                updateIsDone(Integer.parseInt(inputs[1]), allActions);
            } else {
                addAction(inputs[0], input, allActions);
            }

            input = scanner.nextLine();
            inputInLowerCase = input.toLowerCase();
        }

        printWithLines(BYE_HEADER);
    }
}