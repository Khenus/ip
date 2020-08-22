import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String content = " Hello! I'm Duke\n"
                + " What can I do for you?\n";

        String topLine = "____________________________________________________________\n";
        String bottomLine = "____________________________________________________________";

        System.out.println(topLine + content + bottomLine);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("bye")) {
            if (!input.equals("bye")) {
                System.out.println(topLine + "You typed in \"" + input + "\"");
                System.out.println(bottomLine);
            }

            input = scanner.nextLine();
        }

        content = " Bye Bye! Hope to see you again soon!\n";
        System.out.println(topLine + content + bottomLine);
    }
}