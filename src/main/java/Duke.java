import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static ArrayList<Task> allActions = new ArrayList<>();

    public static void printWithLines(String stringToPrint) {
        String finalString = "____________________________________________________________\n"
                + stringToPrint
                + "\n____________________________________________________________";

        System.out.println(finalString);
    }

    public static void listAllActions() {
        String fullList = " Here are the tasks in your list:\n";

        for (int i = 0; i < allActions.size(); i++) {
            fullList += " " + (i + 1) + "." + allActions.get(i).getFullTask();

            if (i != allActions.size() - 1) {
                fullList +=  "\n";
            }
        }

        printWithLines(fullList);
    }

    public static void addAction(String userInput) {
        Task newTask = new Task(userInput);
        allActions.add(newTask);
        printWithLines(" added: " + userInput);
    }

    public static void updateIsDone(int numberToUpdate) {
        if (numberToUpdate > allActions.size()) {
            printWithLines("Invalid task number");
        } else {
            allActions.get(numberToUpdate - 1).setIsDone(true);
            printWithLines("Nice! I've marked this task as done:\n " + allActions.get(numberToUpdate - 1).getFullTask());
        }
    }

    public static void main(String[] args) {
        printWithLines(" Hello! I'm Duke\n" + " What can I do for you?");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            String[] inputs = input.split(" ");
            if (inputs[0].equals("list")) {
                listAllActions();
            } else if (inputs[0].equals("done")) {
                updateIsDone(Integer.parseInt(inputs[1]));
            } else {
                addAction(input);
            }

            input = scanner.nextLine();
        }

        printWithLines(" Bye Bye! Hope to see you again soon!");
    }
}