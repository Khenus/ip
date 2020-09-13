package duke.task;

public class Event extends Task {
    private String dateAt;

    public Event(String[] descriptionWithTime) {
        super(descriptionWithTime[0]);
        this.dateAt = descriptionWithTime[1];
    }

    public Event(String description, String dateAt, String isDone) {
        super(description, isDone);
        this.dateAt = dateAt;
    }

    @Override
    public String getFullTask() {
        String eventDate = " (at: " + dateAt + ")";
        return String.format("[E]%s%s", super.getFullTask(), eventDate);
    }

    @Override
    public String getTaskToSave() {
        return String.format("E | %s | %s", super.getTaskToSave(), dateAt);
    }
}
