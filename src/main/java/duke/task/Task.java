package duke.task;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Boolean.valueOf;

public class Task {
    private String taskDescription;
    private boolean isDone;

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.isDone = false;
    }

    public Task(String taskDescription, String isDone) {
        this.taskDescription = taskDescription;
        this.isDone = parseBoolean(isDone);
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setIsDone(boolean newIsDone) {
        this.isDone = newIsDone;
    }

    public String getFullTask() {
        /** For automated testing, replace isDoneSymbol with the following line,
         * String isDoneSymbol = isDone ? "✓" : "✗";
         *
         * For production, replace isDoneSymbol with the following line,
         * String isDoneSymbol = isDone ? "\u2713" : "\u2717";
         */

        String isDoneSymbol = isDone ? "✓" : "✗";
        return String.format("[%s] %s", isDoneSymbol, taskDescription);
    }

    public String getTaskToSave() {
        return String.format("%s | %s", valueOf(isDone), taskDescription);
    }
}
