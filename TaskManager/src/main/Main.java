package main;

import tasks.Epic;
import tasks.Subtask;
import tasks.Task;
import utility.InMemoryHistoryManager;
import utility.InMemoryTaskManager;

public class Main {
    public static InMemoryTaskManager taskManager = new InMemoryTaskManager();
    public static InMemoryHistoryManager historyManager = new InMemoryHistoryManager();

    public static void main(String[] args) {
        Epic newEpic = new Epic("11", "123123");
        Subtask subtask1 = new Subtask("10","1444", newEpic);
        Subtask subtask11 = new Subtask("11","1444", newEpic);
        Subtask subtask12 = new Subtask("12", "1444", newEpic);
        Epic newEpic2 = new Epic("22", "2222222");
        taskManager.getSubtask(subtask11.hashCode());
        taskManager.getSubtask(subtask12.hashCode());
        taskManager.getEpic(newEpic2.hashCode());
        taskManager.getEpic(newEpic.hashCode());
        System.out.println(taskManager.getCollectionEpic());
        System.out.println(historyManager.getHistory());
        taskManager.getSubtask(subtask11.hashCode());
        System.out.println(historyManager.getHistory());
    }
}