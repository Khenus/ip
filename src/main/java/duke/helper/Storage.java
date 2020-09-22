package duke.helper;

import duke.exceptions.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Todo;
import duke.task.Task;
import duke.task.TaskList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static duke.Constants.FILE_NOT_FOUND;
import static duke.Constants.FILE_SUCCESSFULLY_READ;
import static duke.Constants.SAVE_FILE_ACCESS_FAILURE;
import static duke.helper.Ui.printInitializer;

/**
 * A class to handle file IO
 *
 * @author Khenus Tan
 */
public class Storage {
    private String filePath;
    private ArrayList<Task> allActions;

    /**
     * Constructor for Storage class
     *
     * @param filePath The String containing the file path of the save file
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * A function to load data from a save file into a ArrayList of Tasks
     *
     * @return ArrayList
     * @throws DukeException If file is corrupted or not found
     */
    public ArrayList<Task> load() throws DukeException {
        Scanner fileReader = null;
        allActions = new ArrayList<>();

        try {
            File saveFile = new File(filePath);
            fileReader = new Scanner(saveFile);

            while (fileReader.hasNextLine()) {
                String[] fileInputs = fileReader.nextLine().split(" \\| ");

                if (fileInputs[0].equals("T")) {
                    Todo newTask = new Todo(fileInputs[1], fileInputs[2]);
                    allActions.add(newTask);
                } else if (fileInputs[0].equals("D")) {
                    String timeBy = null;
                    if (fileInputs.length > 4) {
                        timeBy = fileInputs[4];
                    }

                    Deadline newTask = new Deadline(fileInputs[1], fileInputs[2], fileInputs[3], timeBy);
                    allActions.add(newTask);
                } else if (fileInputs[0].equals("E")) {
                    String timeAt = null;
                    if (fileInputs.length > 4) {
                        timeAt = fileInputs[4];
                    }

                    Event newTask = new Event(fileInputs[1], fileInputs[2], fileInputs[3], timeAt);
                    allActions.add(newTask);
                }
            }

            fileReader.close();
            printInitializer(FILE_SUCCESSFULLY_READ);
        } catch (FileNotFoundException fileReadingError) {
            throw new DukeException(FILE_NOT_FOUND);
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

        return allActions;
    }

    /**
     * A funtion to write data into a save file from a Task List
     *
     * @param dataList The TaskList containing all added tasks
     */
    public void write(TaskList dataList) {
        allActions = dataList.getFullArray();
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            String toWrite = "";

            for (Task currentTask : allActions) {
                toWrite += currentTask.getTaskToSave() + "\n";
            }

            fileWriter.write(toWrite);
            fileWriter.close();
        } catch (IOException fileAccessError) {
            System.out.println(SAVE_FILE_ACCESS_FAILURE);
            fileAccessError.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException fileAccessError) {
                System.out.println(SAVE_FILE_ACCESS_FAILURE);
            }
        }
    }
}
