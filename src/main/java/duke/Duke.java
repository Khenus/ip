package duke;

import duke.task.Task;

import java.util.Scanner;
import java.util.ArrayList;

import static duke.Constants.BYE_HEADER;
import static duke.Constants.GREETING_HEADER_TOP;
import static duke.Constants.GREETING_HEADER_BOTTOM;

import static duke.commands.Done.updateIsDone;
import static duke.commands.AddTask.addAction;
import static duke.commands.List.listAllActions;
import static duke.commands.Delete.deleteTask;
import static duke.helper.SpecialPrint.printWithLines;

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
            } else if (inputs[0].equals("delete")) {
                deleteTask(input, allActions);
            } else {
                addAction(inputs[0], input, allActions);
            }

            input = scanner.nextLine();
            inputInLowerCase = input.toLowerCase();
        }

        printWithLines(BYE_HEADER);
    }
}