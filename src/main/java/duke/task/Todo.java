package duke.task;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    public Todo(String description, String isDone) {
        super(description, isDone);
    }

    @Override
    public String getFullTask() {
        return String.format("[T]%s", super.getFullTask());
    }

    @Override
    public String getTaskToSave() {
        return String.format("T | %s", super.getTaskToSave());
    }
}
