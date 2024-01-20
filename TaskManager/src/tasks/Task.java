package tasks;

import java.util.Objects;

import static main.Main.taskManager;

public class Task {
    protected String nameTask;
    protected String descriptionTask;
    protected Status status;

    public Task() {
        //заглушка для редактирования конструкторов подклвссов
        if (getClass() == Task.class) {
            throw new RuntimeException("Для создания задачи необходимо ввести ее название и описание");
        }
    }

    public Task(String nameTask, String descriptionTask) {
        setParametrsCostructor(nameTask, descriptionTask);
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
        return "Задача[" +
                "имя задачи: '" + nameTask + '\'' +
                ", описание задачи: '" + descriptionTask + '\'' +
                ", статус: " + status +
                ']';
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        if (nameTask != null && nameTask != "") {
            this.nameTask = nameTask;
        } else {
            throw new RuntimeException("Имя задачи введено некорректно");
        }
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        if (descriptionTask != null && nameTask != "") {
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

    public void setParametrsCostructor(String nameTask, String descriptionTask) {
        setNameTask(nameTask);
        setDescriptionTask(descriptionTask);
        status = Status.NEW;
    }
}
