package duke;

/**
 * A class containing all constants in Duke
 *
 * @author Khenus Tan
 */
public class Constants {
    public static final String FRONT_SPACING = " ";
    public static final String NEW_LINE = "\n";
    public static final String TOP_LINE = "____________________________________________________________\n";
    public static final String BOTTOM_LINE = "\n____________________________________________________________";
    public static final String LIST_HEADER = FRONT_SPACING + "Here are the tasks in your list:\n";
    public static final String INVALID_TASK = FRONT_SPACING + "Invalid task to insert";
    public static final String TASK_HEADER = FRONT_SPACING + "Got it. I've added this task: \n";
    public static final String NOT_NUMBER_DELETION = FRONT_SPACING + "The description of delete must be a number!";
    public static final String OUT_OF_BOUND_DELETION = FRONT_SPACING + "The description of delete is larger than the list!";
    public static final String DELETION_HEADER = FRONT_SPACING + "Noted. I've removed this task: \n";
    public static final String CONFIRMATION_FOOTER_FIRST_PART = FRONT_SPACING + "Now you have ";
    public static final String CONFIRMATION_FOOTER_SECOND_PART = " tasks in the list.";
    public static final String INVALID_TASK_NUMBER = "Invalid task number";
    public static final String MARKED_DONE_HEADER = "Nice! I've marked this task as done:\n";
    public static final String GREETING_HEADER_TOP = FRONT_SPACING + "Hello! I'm Duke~\n";
    public static final String GREETING_HEADER_BOTTOM = FRONT_SPACING + "What can I do for you?" + NEW_LINE;
    public static final String AVAILABLE_COMMANDS = FRONT_SPACING + "The available commands are:" + NEW_LINE +
            FRONT_SPACING + FRONT_SPACING + " - todo <description>" + NEW_LINE +
            FRONT_SPACING + FRONT_SPACING + " - deadline <description> /by <date in yyyy-mm-dd>, <time (optional)>" + NEW_LINE +
            FRONT_SPACING + FRONT_SPACING + " - event <description> /at <date in yyyy-mm-dd>, <time (optional)>" + NEW_LINE +
            FRONT_SPACING + FRONT_SPACING + " - list" + NEW_LINE +
            FRONT_SPACING + FRONT_SPACING + " - help" + NEW_LINE +
            FRONT_SPACING + FRONT_SPACING + " - print [deadline/event] <date in yyyy-mm-dd>" + NEW_LINE +
            FRONT_SPACING + FRONT_SPACING + " - done <index>" + NEW_LINE +
            FRONT_SPACING + FRONT_SPACING + " - find <keyword>" + NEW_LINE +
            FRONT_SPACING + FRONT_SPACING + " - delete <index of task>";
    public static final String BYE_HEADER = FRONT_SPACING + "Bye Bye! Hope to see you again soon!";
    public static final String DATE_FORMAT_ERROR = FRONT_SPACING + "☹ OOPS!!! The format of the date must be yyyy-mm-dd!";

    //For File Handler
    public static final String INITIALIZER = FRONT_SPACING + "Initializing...\n";
    public static final String SAVING_INFO = FRONT_SPACING + "(All Changes will be automatically saved)";
    public static final String FILE_NOT_FOUND = FRONT_SPACING + "Save file not found.";
    public static final String FILE_SUCCESSFULLY_READ = FRONT_SPACING + "File successfully read!\n";
    public static final String SAVE_FILE_ACCESS_FAILURE = FRONT_SPACING + "Error accessing save file\n";
}
