package utility;

import tasks.Epic;
import tasks.Subtask;
import tasks.Task;
import tasks.TypeTask;

import java.util.HashMap;

import static main.Main.*;

public class InMemoryTaskManager implements TaskManager {
    /*поля обозначены private чтобы исключить неопределенность в месте хранения данных, теперь коллекции хранят данные
    только в объекте taskManager, все наследники этого менеджера лишь определяют особый фунционал, но не хранят в себе данные*/
    private final HashMap<Integer, Task> collectionTask = new HashMap<>();
    private final HashMap<Integer, Subtask> collectionSubtask = new HashMap<>();
    private final HashMap<Integer, Epic> collectionEpic = new HashMap<>();

    //реализация удаления элемента через объект
    @Override //удаление элемента
    public <E extends Task> void deleteCollectionElement(E element) {
        if (element.getClass().equals(Task.class)) {
            collectionTask.remove(element.getId());
        } else if (element.getClass().equals(Subtask.class)) {
            collectionSubtask.remove(element.getId());
        } else if (element.getClass().equals(Epic.class)) {
            collectionEpic.remove(element.getId());
        } else {
            throw new RuntimeException("Невозможно удалить элемент данного типа");
        }
    }

    //реализация удаления элемента с помощью хэш кода
    public void deleteCollectionElement(TypeTask type, int id) {
        switch (type) {
            case TASK -> collectionTask.remove(id);
            case SUBTASK -> collectionSubtask.remove(id);
            case EPIC -> collectionEpic.remove(id);
        }
    }

    @Override
    public <E extends Task> void updateCollectionElement(E element) {
        if (element.getClass().equals(Task.class)) {
            collectionTask.put(element.getId(), (Task) element);
        } else if (element.getClass().equals(Subtask.class)) {
            collectionSubtask.put(element.getId(), (Subtask) element);
        } else if (element.getClass().equals(Epic.class)) {
            collectionEpic.put(element.getId(), (Epic) element);
        } else {
            throw new RuntimeException("Невозможно вставить элемент данного типа");
        }
    }

    @Override
    public void cleanCollection(TypeTask type) {    //очистка списка всех задач
        switch (type) {
            case TASK:
                collectionTask.clear();
                System.out.println("Список задач очищен");
                break;
            case SUBTASK:
                collectionSubtask.clear();
                System.out.println("Список подзадач очищен");
                break;
            case EPIC:
                collectionEpic.clear();
                System.out.println("Список глобальных задач очищен");
                break;
            default:
                System.out.println("Такого типа задач нет");
        }
    }

    //получение элемента по id
    @Override
    public Task getTask(int id) {
        if (collectionTask.containsKey(id)) {
            historyManager.add(collectionTask.get(id));
            return collectionTask.get(id);
        } else {
            throw new RuntimeException("Такой задачи не существует");
        }
    }

    @Override
    public Subtask getSubtask(int id) {
        if (collectionSubtask.containsKey(id)) {
            historyManager.add(collectionSubtask.get(id));
            return collectionSubtask.get(id);
        } else {
            throw new RuntimeException("Такой подзадачи не существует");
        }
    }

    @Override
    public Epic getEpic(int id) {
        if (collectionEpic.containsKey(id)) {
            historyManager.add(collectionEpic.get(id));
            return collectionEpic.get(id);
        } else {
            throw new RuntimeException("Такого эпика не существует");
        }
    }
    //возвращает элемент без отметки о его вызове в истории просмотра
    public Task silentGetElement(int id) {
        for (Task value : taskManager.getCollectionTask().values()) {
            if (id == value.getId()) return value;
        }
        for (Subtask value : taskManager.getCollectionSubtask().values()) {
            if (id == value.getId()) return value;
        }
        for (Epic value : taskManager.getCollectionEpic().values()) {
            if (id == value.getId()) return value;
        }
        throw new RuntimeException("Элемента с таким id не существует");
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
