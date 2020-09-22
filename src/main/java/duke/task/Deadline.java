package duke.task;

import duke.exceptions.DukeTimeFormatException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * A class for Deadline
 *
 * @author Khenus Tan
 */
public class Deadline extends Task {
    private LocalDate dateBy;
    private LocalTime timeBy = null;

    /**
     * Constructor for user creation of new deadline
     *
     * @param descriptionWithTime A String Array containing spliced user input
     * @throws DukeTimeFormatException If time format entered by user is un-parsable
     */
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

    /**
     * Constructor for loading deadline from file
     *
     * @param isDone A String for data regarding whether deadline is done
     * @param description A String for description of Deadline
     * @param dateBy A String for the due date of Deadline
     * @param timeBy A String for the latest time of submission of Deadline
     */
    public Deadline(String isDone, String description, String dateBy, String timeBy) {
        super(description, isDone);
        this.dateBy = LocalDate.parse(dateBy);

        if (timeBy != null) {
            this.timeBy = LocalTime.parse(timeBy.trim(), DateTimeFormatter.ofPattern("HHmm"));
        }
    }

    /**
     * A getter retrieve the due date of the Deadline
     *
     * @return LocalDate
     */
    public LocalDate getDateBy() {
        return dateBy;
    }

    /**
     * A function to return current Deadline as a String to be shown to user
     *
     * @return String
     */
    @Override
    public String getFullTask() {
        String dateTimeInString = dateBy.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

        if (timeBy != null) {
            dateTimeInString += ", " + timeBy.format(DateTimeFormatter.ofPattern("HHmm")) + " hrs";
        }

        String dueDate = " (by: " + dateTimeInString + ")";
        return String.format("[D]%s%s", super.getFullTask(), dueDate);
    }

    /**
     * A function to return current Deadline as a String to be saved into a file
     *
     * @return String
     */
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
