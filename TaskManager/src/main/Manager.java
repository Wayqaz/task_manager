package main;

import tasks.Epic;
import tasks.Subtask;
import tasks.Task;

import java.util.HashMap;

public class Manager {
    private HashMap<Integer, Task> collectionTask = new HashMap<>();
    private HashMap<Integer, Subtask> collectionSubtask = new HashMap<>();
    private HashMap<Integer, Epic> collectionEpic = new HashMap<>();

    public void deleteCollectionTask(int hash) { //удаление элемента по хэшу
        collectionTask.remove(hash);
    }

    public void deleteCollectionSubtask(int hash) {
        collectionSubtask.remove(hash);
    }

    public void deleteCollectionEpic(int hash) {
        collectionEpic.remove(hash);
    }

    public void updateCollectionTask(int hash, Task task) { //добавление или изменение задачи
        collectionTask.put(hash, task);
    }

    public void updateCollectionSubtask(int hash, Subtask subtask) {
        collectionSubtask.put(hash, subtask);
    }

    public void updateCollectionEpic(int hash, Epic epic) {
        collectionEpic.put(hash, epic);
    }

    public void cleanCollection(String type) {    //очистка списка всех задач
        switch (type) {
            case "Task":
                collectionTask.clear();
                System.out.println("Список задач очищен");
                break;
            case "Subtask":
                collectionTask.clear();
                System.out.println("Список подзадач очищен");
                break;
            case "Epic":
                collectionTask.clear();
                System.out.println("Список глобальных задач очищен");
                break;
            default:
                System.out.println("Такого типа задач нет");
        }
    }

    public Task getTask(int hash) {   //получение элемента по хэшу
        if (collectionTask.containsKey(hash)) {
            return collectionTask.get(hash);
        } else {
            throw new RuntimeException("Такой задачи не существует");
        }
    }

    public Subtask getSubtask(int hash) {
        if (collectionSubtask.containsKey(hash)) {
            return collectionSubtask.get(hash);
        } else {
            throw new RuntimeException("Такой подзадачи не существует");
        }
    }

    public Epic getEpic(int hash) {
        if (collectionEpic.containsKey(hash)) {
            return collectionEpic.get(hash);
        } else {
            throw new RuntimeException("Такого эпика не существует");
        }
    }

    public HashMap<Integer, Task> getCollectionTask() {  //получение списка всех задач
        return collectionTask;
    }

    public HashMap<Integer, Subtask> getCollectionSubtask() {
        return collectionSubtask;
    }

    public HashMap<Integer, Epic> getCollectionEpic() {
        return collectionEpic;
    }
}
