package duke.helper;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class FileHandler {
    public static void dataInitializer(ArrayList<Task> allActions) {
        InputStreamReader fileStream = null;
        BufferedReader fileReader = null;
        try {
//            System.out.println(new File(".").getAbsolutePath());
            fileStream = new InputStreamReader(FileHandler.class.getResourceAsStream("Data.save"));
            fileReader = new BufferedReader(fileStream);

            String nextLine = fileReader.readLine();
            while (nextLine != null) {
                System.out.println(nextLine);

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
            System.out.println("File successfully read!");
        } catch (IOException fileReadingError) {
            System.out.println("Error while accessing save file!");
        } catch (NullPointerException fileNotFoundError) {
            System.out.println("Save file not found!");

            try {
                File newFile = new File("src/main/java/duke/helper/Data.save");
                if (newFile.createNewFile()) {
                    System.out.println("New save file created successfully!");
                }
            } catch (IOException fileCreationError) {
                System.out.println("Error creating save file!");
            }

        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }

                if (fileStream != null) {
                    fileStream.close();
                }
            }  catch (IOException fileReadingError) {
                System.out.println("Error while accessing save file!");
            }
        }
    }

    public static void dataWriter(ArrayList<Task> allActions) {

    }
}
