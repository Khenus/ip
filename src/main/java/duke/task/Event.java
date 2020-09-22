package duke.task;

import duke.exceptions.DukeTimeFormatException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * A class for new Events
 *
 * @author Khenus Tan
 */
public class Event extends Task {
    private LocalDate dateAt;
    private LocalTime timeAt = null;

    /**
     * Constructor for user creation of new event
     *
     * @param descriptionWithTime A String Array containing spliced user input
     * @throws DukeTimeFormatException If time format entered by user is un-parsable
     */
    public Event(String[] descriptionWithTime) throws DukeTimeFormatException {
        super(descriptionWithTime[0]);

        try {
            String[] dateTime = descriptionWithTime[1].split(",");

            this.dateAt = LocalDate.parse(dateTime[0].trim());
            if (dateTime.length > 1) {
                this.timeAt = LocalTime.parse(dateTime[1].trim(), DateTimeFormatter.ofPattern("HHmm"));
            }
        } catch (DateTimeParseException dateFormatError) {
            throw new DukeTimeFormatException();
        }
    }

    /**
     * Constructor for loading event from file
     *
     * @param isDone A String for data regarding whether Event is done
     * @param description A String for description of Event
     * @param dateAt A String for the date of Event
     * @param timeAt A String for the time of Event
     */
    public Event(String isDone, String description, String dateAt, String timeAt) {
        super(description, isDone);
        this.dateAt = LocalDate.parse(dateAt.trim());

        if (timeAt != null) {
            this.timeAt = LocalTime.parse(timeAt.trim(), DateTimeFormatter.ofPattern("HHmm"));
        }
    }

    /**
     * A getter retrieve the date of the Event
     *
     * @return LocalDate
     */
    public LocalDate getDateAt() {
        return dateAt;
    }

    /**
     * A function to return current Event as a String to be shown to user
     *
     * @return String
     */
    @Override
    public String getFullTask() {
        String dateTimeInString = dateAt.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

        if (timeAt != null) {
            dateTimeInString += ", " + timeAt.format(DateTimeFormatter.ofPattern("HHmm")) + " hrs";
        }

        String eventDate = " (at: " + dateTimeInString + ")";
        return String.format("[E]%s%s", super.getFullTask(), eventDate);
    }

    /**
     * A function to return current Event as a String to be saved into a file
     *
     * @return String
     */
    @Override
    public String getTaskToSave() {
        String dateInString = dateAt.toString();

        if (timeAt != null) {
            String timeInString = timeAt.format(DateTimeFormatter.ofPattern("HHmm"));
            return String.format("E | %s | %s | %s", super.getTaskToSave(), dateInString, timeInString);
        } else {
            return String.format("E | %s | %s", super.getTaskToSave(), dateInString);
        }
    }
}
