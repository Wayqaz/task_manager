package utility;

import tasks.Task;
import utility.DoublyLinkedList.DoublyLinkedList;

import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private DoublyLinkedList<Task> history = new DoublyLinkedList<>();

    @Override
    public void add(Task task) {
        history.linkLast(task);
    }

    @Override
    public List<Task> getHistory() {
        return history.getTasks();
    }

    @Override
    public void remove(int hashCode) {
        history.removeNode(history.getAccordance().get(hashCode));
    }
}
