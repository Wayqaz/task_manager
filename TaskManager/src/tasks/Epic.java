package tasks;

import java.util.ArrayList;

import static main.Main.manager;

public class Epic extends Task {
    private ArrayList<Subtask> collectionSubtask = new ArrayList<>();

    public Epic(String nameTask, String descriptionTask) {
        super();
        setParametrsCostructor(nameTask, descriptionTask);
        manager.updateCollectionEpic(this.hashCode(), this);
    }

    @Override
    public void setStatus(String status) {
        System.out.println("Изменения статуса выполнения не доступно для данного тип задач");
    }

    public ArrayList<Subtask> getCollectionSubtask() {
        return collectionSubtask;
    }

    public void addCollectionSubtask(Subtask subtaskHash) {
        collectionSubtask.add(subtaskHash);
    }
}
