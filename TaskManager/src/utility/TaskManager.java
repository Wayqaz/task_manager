package utility;

import tasks.Epic;
import tasks.Subtask;
import tasks.Task;
import tasks.TypeTask;

public interface TaskManager {
    public <E extends Task> void deleteCollectionElement(E element);

    public <E extends Task> void updateCollectionElement(E element);

    public void cleanCollection(TypeTask type);

    public Task getTask(int id);

    public Subtask getSubtask(int id);

    public Epic getEpic(int id);
}
