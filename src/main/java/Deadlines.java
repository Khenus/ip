public class Deadlines extends Task {
    private String dateBy;

    public Deadlines(String[] descriptionWithTime) {
        super(descriptionWithTime[0]);
        this.dateBy = descriptionWithTime[1];
    }

    @Override
    public String getFullTask() {
        String dueDate = " (by: " + dateBy + ")";
        return String.format("[D]%s%s", super.getFullTask(), dueDate);
    }
}
