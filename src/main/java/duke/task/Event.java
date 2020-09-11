package duke.task;

public class Event extends Task {
    private String dateAt;

    public Event(String[] descriptionWithTime) {
        super(descriptionWithTime[0]);
        this.dateAt = descriptionWithTime[1];
    }

    @Override
    public String getFullTask() {
        String eventDate = " (at: " + dateAt + ")";
        return String.format("[E]%s%s", super.getFullTask(), eventDate);
    }
}
