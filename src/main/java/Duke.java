import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static ArrayList<String> allActions = new ArrayList<>();

    public static void printWithLines(String stringToPrint) {
        String finalString = "____________________________________________________________\n"
                + stringToPrint
                + "\n____________________________________________________________";

        System.out.println(finalString);
    }

    public static void listAllActions() {
        String fullList = "";

        for (int i = 0; i < allActions.size(); i++) {
            fullList += " " + (i + 1) + ". " + allActions.get(i);

            if (i != allActions.size() - 1) {
                fullList +=  "\n";
            }
        }

        printWithLines(fullList);
    }

    public static void addAction(String userInput) {
        allActions.add(userInput);
        printWithLines(" added: " + userInput);
    }

    public static void main(String[] args) {
        printWithLines(" Hello! I'm Duke\n" + " What can I do for you?");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            if (input.equals("list")) {
                listAllActions();
            } else {
                addAction(input);
            }

            input = scanner.nextLine();
        }

        printWithLines(" Bye Bye! Hope to see you again soon!");
    }
}