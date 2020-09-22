package duke.task;

import duke.exceptions.DukeTimeFormatException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDate dateBy;
    private LocalTime timeBy = null;

    public Deadline(String[] descriptionWithTime) throws DukeTimeFormatException {
        super(descriptionWithTime[0]);

        try {
            String[] dateTime = descriptionWithTime[1].split(",");

            this.dateBy = LocalDate.parse(dateTime[0].trim());
            if (dateTime.length > 1) {
                this.timeBy = LocalTime.parse(dateTime[1].trim(), DateTimeFormatter.ofPattern("HHmm"));
            }
        } catch (DateTimeParseException dateFormatError) {
            throw new DukeTimeFormatException();
        }
    }

    public Deadline(String isDone, String description, String dateBy, String timeBy) {
        super(description, isDone);
        this.dateBy = LocalDate.parse(dateBy);

        if (timeBy != null) {
            this.timeBy = LocalTime.parse(timeBy.trim(), DateTimeFormatter.ofPattern("HHmm"));
        }
    }

    @Override
    public String getFullTask() {
        String dateTimeInString = dateBy.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

        if (timeBy != null) {
            dateTimeInString += ", " + timeBy.format(DateTimeFormatter.ofPattern("HHmm")) + " hrs";
        }

        String dueDate = " (by: " + dateTimeInString + ")";
        return String.format("[D]%s%s", super.getFullTask(), dueDate);
    }

    @Override
    public String getTaskToSave() {
        String dateInString = dateBy.toString();

        if (timeBy != null) {
            String timeInString = timeBy.format(DateTimeFormatter.ofPattern("HHmm"));
            return String.format("D | %s | %s | %s", super.getTaskToSave(), dateInString, timeInString);
        } else {
            return String.format("D | %s | %s", super.getTaskToSave(), dateInString);
        }
    }
}
