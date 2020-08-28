import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static ArrayList<Task> allActions = new ArrayList<>();

    //Printing information within bounding lines
    public static void printWithLines(String stringToPrint) {
        String finalString = "____________________________________________________________\n"
                + stringToPrint
                + "\n____________________________________________________________";

        System.out.println(finalString);
    }

    //Listing all stored actions
    public static void listAllActions() {
        String fullList = "\tHere are the tasks in your list:\n";

        for (int i = 0; i < allActions.size(); i++) {
            fullList += "\t" + (i + 1) + "." + allActions.get(i).getFullTask();

            if (i != allActions.size() - 1) {
                fullList +=  "\n";
            }
        }
        printWithLines(fullList);
    }

    //Storing new action into Array List
    public static void addAction(String command, String userInput) {
        int firstSpacebarAt = userInput.indexOf(" ");
        String description = userInput.substring(firstSpacebarAt + 1);

        String taskConfirmation = "";

        if (command.equals("todo")) {
            Todo newTodo = new Todo(description);
            allActions.add(newTodo);
            taskConfirmation = newTodo.getFullTask();

        } else if (command.equals("deadline")) {
            String[] details = description.split(" /by ");

            Deadlines newDeadline = new Deadlines(details);
            allActions.add(newDeadline);
            taskConfirmation = newDeadline.getFullTask();

        } else if (command.equals("event")) {
            String[] details = description.split(" /at ");

            Event newEvent = new Event(details);
            allActions.add(newEvent);
            taskConfirmation = newEvent.getFullTask();
        }

        if (taskConfirmation.equals("")) {
            printWithLines("Invalid task to insert");
        } else {
            printWithLines("\tGot it. I've added this task: \n\t\t"
                    + taskConfirmation
                    + "\n\tNow you have " + allActions.size() + " tasks in the list.");
        }
    }

    //Update task if the value being entered is valid
    public static void updateIsDone(int numberToUpdate) {
        if (numberToUpdate > allActions.size() || numberToUpdate < 1) {
            printWithLines("Invalid task number");
        } else {
            allActions.get(numberToUpdate - 1).setIsDone(true);
            printWithLines("Nice! I've marked this task as done:\n "
                    + allActions.get(numberToUpdate - 1).getFullTask());
        }
    }

    public static void main(String[] args) {
        printWithLines(" Hello! I'm Duke\n" + " What can I do for you?");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String inputInLowerCase = input.toLowerCase();

        while (!inputInLowerCase.equals("bye")) {
            String[] inputs = inputInLowerCase.split(" ");
            if (inputs[0].equals("list")) {
                listAllActions();
            } else if (inputs[0].equals("done")) {
                updateIsDone(Integer.parseInt(inputs[1]));
            } else {
                addAction(inputs[0], input);
            }

            input = scanner.nextLine();
            inputInLowerCase = input.toLowerCase();
        }

        printWithLines(" Bye Bye! Hope to see you again soon!");
    }
}