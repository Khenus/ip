package duke.task;

/**
 * A Class for new Todo
 *
 * @author Khenus Tan
 */
public class Todo extends Task {
    /**
     * Constructor for user creation of new todo
     *
     * @param description A String containing description of todo
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Constructor for loading Todo from file
     *
     * @param isDone A String for data regarding whether Todo is done
     * @param description A String for description of Todo
     */
    public Todo(String isDone, String description) {
        super(description, isDone);
    }

    /**
     * A function to return current Todo as a String to be shown to user
     *
     * @return String
     */
    @Override
    public String getFullTask() {
        return String.format("[T]%s", super.getFullTask());
    }

    /**
     * A function to return current Todo as a String to be saved into a file
     *
     * @return String
     */
    @Override
    public String getTaskToSave() {
        return String.format("T | %s", super.getTaskToSave());
    }
}
