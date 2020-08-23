import java.util.Scanner;

public class Duke {
    public static void printWithLines(String stringToPrint) {
        String finalString = "____________________________________________________________\n"
                + stringToPrint
                + "\n____________________________________________________________";

        System.out.println(finalString);
    }

    public static void main(String[] args) {
        printWithLines(" Hello! I'm Duke\n" + " What can I do for you?");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            printWithLines(" You typed in \"" + input + "\"");
            input = scanner.nextLine();
        }

        printWithLines(" Bye Bye! Hope to see you again soon!");
    }
}