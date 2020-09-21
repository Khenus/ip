package duke.task;

import java.util.ArrayList;

public class TaskList {
    public ArrayList<Task> allActions;

    public TaskList() {
        this.allActions = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> allActions) {
        this.allActions = allActions;
    }

    public void add(Task newTask) {
        allActions.add(newTask);
    }

    public void remove(int numberToRemove) {
        allActions.remove(numberToRemove);
    }

    public int size() {
        return allActions.size();
    }

    public Task get(int index) {
        return allActions.get(index);
    }

    public ArrayList<Task> getFullArray() {
        return allActions;
    }
}
