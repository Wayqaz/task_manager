package utility;

import tasks.Task;

public interface TaskManager {
    public <E extends Task> void deleteCollectionElement(E element);

    public <E extends Task> void updateCollectionElement(E element);

    public void cleanCollection(String type);
}
