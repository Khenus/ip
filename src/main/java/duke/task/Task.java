package duke.task;

public class Task {
    private String taskDescription;
    private boolean isDone;

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.isDone = false;
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
}
