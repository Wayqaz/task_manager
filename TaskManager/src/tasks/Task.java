package tasks;

import java.util.ArrayList;
import java.util.Objects;

import static main.Main.taskManager;

public class Task {
    protected String nameTask;
    protected String descriptionTask;
    protected Status status;
    protected Integer id;

    public Task(String nameTask, String descriptionTask) {
        setNameTask(nameTask);
        setDescriptionTask(descriptionTask);
        status = Status.NEW;
        setId();
        taskManager.updateCollectionElement(this);
    }

    public Task(int id, String nameTask, Status status, String descriptionTask) {
        this.id = id;
        this.nameTask = nameTask;
        this.status = status;
        this.descriptionTask = descriptionTask;
        taskManager.updateCollectionElement(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(status, task.status) && Objects.equals(nameTask, task.nameTask) &&
                Objects.equals(descriptionTask, task.descriptionTask);
    }

    @Override
    public int hashCode() {                           //уникальный идентификатор задачи
        return Objects.hash(nameTask, descriptionTask, status);
    }

    @Override
    public String toString() {
        TypeTask taskClass = null;
        if (getClass().equals(Task.class)) {
            taskClass = TypeTask.TASK;
        } else if (getClass().equals(Subtask.class)) {
            taskClass = TypeTask.SUBTASK;
        } else if (getClass().equals(Epic.class)) {
            taskClass = TypeTask.EPIC;
        }
        return String.format("%d,%S,%s,%S,%s", getId(), taskClass, nameTask, status, descriptionTask);
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        if (nameTask != null && !nameTask.equals("")) {
            this.nameTask = nameTask;
        } else {
            throw new RuntimeException("Имя задачи введено некорректно");
        }
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        if (descriptionTask != null && !nameTask.equals("")) {
            this.descriptionTask = descriptionTask;
        } else {
            throw new RuntimeException("Описание задачи введено некорректно");
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    protected void setId() {
        if (Objects.isNull(id)) {
            ArrayList<Integer> listId = new ArrayList<>();
            int id = 1;
            for (Task value : taskManager.getCollectionTask().values()) {
                listId.add(value.getId());
            }
            for (Subtask value : taskManager.getCollectionSubtask().values()) {
                listId.add(value.getId());
            }
            for (Epic value : taskManager.getCollectionEpic().values()) {
                listId.add(value.getId());
            }
            while (true) {
                if (!listId.contains(id)) {
                    this.id = id;
                    break;
                }
                id++;
            }
        }
    }
}
