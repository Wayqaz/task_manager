package tasks;

import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task {
    private final ArrayList<Subtask> collectionSubtask = new ArrayList<>();

    public Epic(String nameTask, String descriptionTask) {
        super(nameTask, descriptionTask);
    }

    public Epic(int id, String nameTask, Status status, String descriptionTask) {
        super(id, nameTask, status, descriptionTask);
    }

    @Override
    public void setStatus(Status status) {
        System.out.println("Изменения статуса выполнения не доступно для данного тип задач");
    }

    public ArrayList<Subtask> getCollectionSubtask() {
        return collectionSubtask;
    }

    public void addCollectionSubtask(Subtask subtaskHash) {
        collectionSubtask.add(subtaskHash);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(collectionSubtask, epic.collectionSubtask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), collectionSubtask);
    }
}
