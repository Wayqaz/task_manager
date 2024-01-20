package tasks;

import java.util.ArrayList;

import static main.Main.taskManager;

public class Epic extends Task {
    private ArrayList<Subtask> collectionSubtask = new ArrayList<>();

    public Epic(String nameTask, String descriptionTask) {
        super();
        setParametrsCostructor(nameTask, descriptionTask);
        taskManager.updateCollectionElement(this);
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
    public String toString() {
        return "Эпик[" +
                "имя эпика: '" + nameTask + '\'' +
                ", описание эпика: '" + descriptionTask + '\'' +
                ", статус: " + status +
                ']';
    }
}
