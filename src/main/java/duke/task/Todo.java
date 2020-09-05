package duke.task;

public class Todo extends Task {
    public Todo(String taskDescription) {
        super(taskDescription);
    }

    @Override
    public String getFullTask() {
        return String.format("[T]%s", super.getFullTask());
    }
}
