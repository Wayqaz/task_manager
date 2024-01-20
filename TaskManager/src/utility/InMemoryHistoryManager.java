package utility;

import tasks.Task;

import java.util.LinkedList;

public class InMemoryHistoryManager implements HistoryManager {
    private LinkedList<Task> history = new LinkedList<>();

    @Override
    public void add(Task task) {
        history.add(task);
        if (history.size() > 10) {
            history.remove(0);
        }
    }

    @Override
    public LinkedList<Task> getHistory() {
        return history;
    }
}
