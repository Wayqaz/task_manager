package tasks;

import java.util.Objects;

import static main.Main.manager;

public class Task {
    protected String nameTask;
    protected String descriptionTask;
    protected String status;

    public Task() {
        //заглушка для редактирования конструкторов подклвссов
        if (getClass() == Task.class) {
            throw new RuntimeException("Для создания задачи необходимо ввести ее название и описание");
        }
    }

    public Task(String nameTask, String descriptionTask) {
        setParametrsCostructor(nameTask, descriptionTask);
        manager.updateCollectionTask(this.hashCode(), this);
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
        return "tasks.Task{" +
                "nameTask='" + nameTask + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", status=" + status +
                '}';
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.equals("NEW") || status.equals("IN_PROGRESS") || status.equals("DONE")) {
            this.status = status;
        } else {
            throw new RuntimeException("Статус задан некорректно");
        }
    }

    public void setParametrsCostructor(String nameTask, String descriptionTask) {
        setNameTask(nameTask);
        setDescriptionTask(descriptionTask);
        status = "NEW";
    }
}
