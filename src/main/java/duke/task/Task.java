package duke.task;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Boolean.valueOf;

/**
 * A class for new Tasks
 *
 * @author Khenus Tan
 */
public class Task {
    private String taskDescription;
    private boolean isDone;

    /**
     * Default constructor for Task class
     *
     * @param taskDescription A String containing the description of the task
     */
    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.isDone = false;
    }

    /**
     * Constructor with boolean for Task class to store whether the task is done. Mostly used for file IO
     *
     * @param taskDescription A String containing the description of the task
     * @param isDone A String containing whether the task is done
     */
    public Task(String taskDescription, String isDone) {
        this.taskDescription = taskDescription;
        this.isDone = parseBoolean(isDone);
    }

    /**
     * A setter to update the value of whether the task is done
     *
     * @param newIsDone A Boolean of whether the task is done
     */
    public void setIsDone(boolean newIsDone) {
        this.isDone = newIsDone;
    }

    /**
     * A function to return current Task as a String to be shown to user
     *
     * @return String
     */
    public String getFullTask() {
        String isDoneSymbol = isDone ? "✓" : "✗";
        return String.format("[%s] %s", isDoneSymbol, taskDescription);
    }

    /**
     * A function to return current Task as a String to be saved into a file
     *
     * @return String
     */
    public String getTaskToSave() {
        return String.format("%s | %s", valueOf(isDone), taskDescription);
    }
}
