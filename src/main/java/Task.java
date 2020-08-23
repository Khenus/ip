public class Task {
    private String taskDescription;
    private boolean isDone;

    public Task(String taskInput) {
        this.taskDescription = taskInput;
        this.isDone = false;
    }

    public void setIsDone(boolean newIsDone) {
        this.isDone = newIsDone;
    }

    public String getFullTask() {
        String isDoneSymbol = isDone ? "\u2713" : "\u2717";

        return String.format("[%s] %s", isDoneSymbol, taskDescription);
    }
}
