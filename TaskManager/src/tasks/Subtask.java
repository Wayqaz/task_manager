package tasks;

import java.util.Objects;

public class Subtask extends Task {
    private final Epic masterEpic;

    public Subtask(String nameTask, String descriptionTask, Epic masterEpic) {
        super(nameTask, descriptionTask);
        this.masterEpic = masterEpic;
    }

    public Subtask(int id, String nameTask, Status status, String descriptionTask, Epic masterEpic) {
        super(id, nameTask, status, descriptionTask);
        this.masterEpic = masterEpic;
    }

    @Override
    public String toString() {
        return String.format("%s,%d", super.toString(), masterEpic.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Subtask subtask = (Subtask) o;
        return Objects.equals(masterEpic, subtask.masterEpic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), masterEpic);
    }
}

