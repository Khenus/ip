package duke.helper;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static duke.Constants.FILE_NOT_FOUND;
import static duke.Constants.FILE_SUCCESSFULLY_READ;
import static duke.Constants.SAVE_FILE_ACCESS_FAILURE;

import static duke.helper.SpecialPrint.printInitializer;

public class FileHandler {
    public static void dataInitializer(ArrayList<Task> allActions) {
        Scanner fileReader = null;
        try {
            File saveFile = new File("tasklist.txt");
            fileReader = new Scanner(saveFile);

            while (fileReader.hasNextLine()) {
                String[] fileInputs = fileReader.nextLine().split(" \\| ");

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
            }

            fileReader.close();
            printInitializer(FILE_SUCCESSFULLY_READ);
        } catch (FileNotFoundException fileReadingError) {
            printInitializer(FILE_NOT_FOUND);
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }

    public static void dataWriter(ArrayList<Task> allActions) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("tasklist.txt");
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
