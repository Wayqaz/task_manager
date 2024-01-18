package tasks;

import static main.Main.manager;

public class Subtask extends Task {
    private int masterEpic;

    public Subtask(String nameTask, String descriptionTask, int masterEpic) {
        super();
        setParametrsCostructor(nameTask, descriptionTask);
        this.masterEpic = masterEpic;
        manager.updateCollectionSubtask(this.hashCode(), this);
        manager.getEpic(masterEpic).addCollectionSubtask(this);
    }

}

