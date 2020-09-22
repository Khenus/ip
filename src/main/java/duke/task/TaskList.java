package duke.task;

import java.util.ArrayList;

/**
 * Class for handling TaskList
 *
 * @author Khenus Tan
 */
public class TaskList {
    private ArrayList<Task> allActions;

    /**
     * Default constructor for TaskList
     */
    public TaskList() {
        this.allActions = new ArrayList<>();
    }

    /**
     * Constructor for TaskList from existing ArrayList. Used for file IO operations
     *
     * @param allActions The ArrayList to be converted into TaskList
     */
    public TaskList(ArrayList<Task> allActions) {
        this.allActions = allActions;
    }

    /**
     * Pushing new task entry into TaskList
     *
     * @param newTask The Task to be pushed
     */
    public void add(Task newTask) {
        allActions.add(newTask);
    }

    /**
     * Removing task specific task from TaskList
     *
     * @param numberToRemove An int for the index of task to be removed
     */
    public void remove(int numberToRemove) {
        allActions.remove(numberToRemove);
    }

    /**
     * A function that returns the full size of the TaskList
     *
     * @return int
     */
    public int size() {
        return allActions.size();
    }

    /**
     * A function that gets the Task of a specific index
     *
     * @param index An int for the index of task to be retrieved
     * @return Task
     */
    public Task get(int index) {
        return allActions.get(index);
    }

    /**
     * A function to retrieve the whole TaskList as ArrayList
     *
     * @return ArrayList of Tasks
     */
    public ArrayList<Task> getFullArray() {
        return allActions;
    }
}
