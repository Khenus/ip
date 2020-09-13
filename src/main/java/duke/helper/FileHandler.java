package duke.helper;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

import static duke.Constants.FILE_NOT_FOUND;
import static duke.Constants.FILE_READING_ERROR;
import static duke.Constants.SAVE_FILE_CREATION;
import static duke.Constants.FILE_SUCCESSFULLY_READ;
import static duke.Constants.SAVE_FILE_CREATION_FAILURE;
import static duke.Constants.SAVE_FILE_ACCESS_FAILURE;

import static duke.helper.SpecialPrint.printInitializer;

public class FileHandler {
    public static void dataInitializer(ArrayList<Task> allActions) {
        InputStreamReader fileStream = null;
        BufferedReader fileReader = null;
        try {
            fileStream = new InputStreamReader(FileHandler.class.getResourceAsStream("Data.save"));
            fileReader = new BufferedReader(fileStream);

            String nextLine = fileReader.readLine();
            while (nextLine != null) {
                String[] fileInputs = nextLine.split(" \\| ");

                if (fileInputs[0].equals("T")) {
                    Todo newTask = new Todo(fileInputs[1], fileInputs[2]);
                    allActions.add(newTask);
                } else if (fileInputs[0].equals("D")) {
                    Deadline newTask = new Deadline(fileInputs[1], fileInputs[2], fileInputs[3]);
                    allActions.add(newTask);
                } else if (fileInputs[0].equals("E")) {
                    Event newTask = new Event(fileInputs[1], fileInputs[2], fileInputs[3]);
                    allActions.add(newTask);
                }

                nextLine = fileReader.readLine();
            }

            fileReader.close();
            fileStream.close();
            printInitializer(FILE_SUCCESSFULLY_READ);
        } catch (IOException fileReadingError) {
            printInitializer(FILE_READING_ERROR);
        } catch (NullPointerException fileNotFoundError) {
            String toPrint = FILE_NOT_FOUND;

            try {
                File newFile = new File("src/main/java/duke/helper/Data.save");
                if (newFile.createNewFile()) {
                    toPrint += SAVE_FILE_CREATION;
                }
            } catch (IOException fileCreationError) {
                toPrint += SAVE_FILE_CREATION_FAILURE;
            }

            printInitializer(toPrint);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }

                if (fileStream != null) {
                    fileStream.close();
                }
            }  catch (IOException fileReadingError) {
                printInitializer(FILE_READING_ERROR);
            }
        }
    }

    public static void dataWriter(ArrayList<Task> allActions) {
        OutputStreamWriter fileStream = null;
        BufferedWriter fileWriter = null;

        try {
            fileStream = new OutputStreamWriter(new FileOutputStream("src/main/java/duke/helper/Data.save"));
            fileWriter = new BufferedWriter(fileStream);

            for (Task currentTask : allActions) {
                fileWriter.write(currentTask.getTaskToSave());
                fileWriter.newLine();
            }

            fileWriter.close();
            fileStream.close();
        } catch (IOException fileAccessError) {
            System.out.println(SAVE_FILE_ACCESS_FAILURE);
        } finally {
            try {
                if (fileStream != null) {
                    fileStream.close();
                }

                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException fileAccessError) {
                System.out.println(SAVE_FILE_ACCESS_FAILURE);
            }
        }
    }
}
