import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static final String FRONT_SPACING = " ";
    public static final String NEW_LINE = "\n";
    public static final String TOP_LINE = "____________________________________________________________\n";
    public static final String BOTTOM_LINE = "\n____________________________________________________________";
    public static final String LIST_HEADER = FRONT_SPACING + "Here are the tasks in your list:\n";
    public static final String INVALID_TASK = FRONT_SPACING + "Invalid task to insert";
    public static final String TASK_HEADER = FRONT_SPACING + "Got it. I've added this task: \n";
    public static final String TASK_FOOTER_FIRST_PART = FRONT_SPACING + "Now you have ";
    public static final String TASK_FOOTER_SECOND_PART = " tasks in the list.";
    public static final String INVALID_TASK_NUMBER = "Invalid task number";
    public static final String MARKED_DONE_HEADER = "Nice! I've marked this task as done:\n";
    public static final String GREETING_HEADER_TOP = FRONT_SPACING + "Hello! I'm Duke\n";
    public static final String GREETING_HEADER_BOTTOM = FRONT_SPACING + "What can I do for you?";
    public static final String BYE_HEADER = FRONT_SPACING + "Bye Bye! Hope to see you again soon!";


    public static ArrayList<Task> allActions = new ArrayList<>();

    /**
     * Printing information within bounding lines
     */
    public static void printWithLines(String stringToPrint) {
        String finalString = TOP_LINE + stringToPrint + BOTTOM_LINE;
        System.out.println(finalString);
    }

    /**
     * Listing all stored actions
     */
    public static void listAllActions() {
        String fullList = LIST_HEADER;

        for (int i = 0; i < allActions.size(); i++) {
            fullList += String.format("%s%s.%s", FRONT_SPACING, (i + 1), allActions.get(i).getFullTask());

            if (i != allActions.size() - 1) {
                fullList += NEW_LINE;
            }
        }
        printWithLines(fullList);
    }

    /**
     * Getting confirmation for task creation
     * */
    public static void deadlineCreator(Task newTask) {
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
    public static void addAction(String command, String userInput) {
        try {
            int firstSpaceIndex = userInput.indexOf(" ");
            String description = userInput.substring(firstSpaceIndex + 1);

            if (command.equals("todo")) {
                String[] details = userInput.split(" ");
                Task newTask = new Todo(details);
                deadlineCreator(newTask);
            } else if (command.equals("deadline")) {
                String[] details = description.split(" /by ");
                Task newTask = new Deadline(details);
                deadlineCreator(newTask);
            } else if (command.equals("event")) {
                String[] details = description.split(" /at ");
                Task newTask = new Event(details);
                deadlineCreator(newTask);
            } else {
                printWithLines("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        } catch (IndexOutOfBoundsException indexError){
            printWithLines("☹ OOPS!!! The description of a " + command + " cannot be empty.");
        }
    }

    /**
     * Update task if the value being entered is valid
     */
    public static void updateIsDone(int numberToUpdate) {
        if (numberToUpdate > allActions.size() || numberToUpdate < 1) {
            printWithLines(INVALID_TASK_NUMBER);
        } else {
            allActions.get(numberToUpdate - 1).setIsDone(true);
            printWithLines(MARKED_DONE_HEADER
                    + FRONT_SPACING + allActions.get(numberToUpdate - 1).getFullTask());
        }
    }

    public static void main(String[] args) {
        printWithLines(GREETING_HEADER_TOP + GREETING_HEADER_BOTTOM);

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

        printWithLines(BYE_HEADER);
    }
}