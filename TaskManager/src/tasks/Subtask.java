package tasks;

import static main.Main.taskManager;

public class Subtask extends Task {
    private Epic masterEpic;

    public Subtask(String nameTask, String descriptionTask, Epic masterEpic) {
        super();
        setParametrsCostructor(nameTask, descriptionTask);
        this.masterEpic = masterEpic;
        taskManager.updateCollectionElement(this);
        masterEpic.addCollectionSubtask(this);
    }

    @Override
    public String toString() {
        return "Подзадача[" +
                "имя подзадачи: '" + nameTask + '\'' +
                ", описание подзадачи: '" + descriptionTask + '\'' +
                ", статус: " + status +
                ']';
    }

}

