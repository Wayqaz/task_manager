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
        Task newTask = new Task("12", "1233");
        Epic newEpic = new Epic("12", "123123");
        Subtask subtask = new Subtask("14", "1444", newEpic);
        System.out.println(newTask);
        System.out.println(subtask);
        System.out.println(taskManager.getTask(newTask.hashCode()) +"\n"+ taskManager.getEpic(newEpic.hashCode()) +"\n"+
                taskManager.getSubtask(subtask.hashCode()));
        System.out.println(historyManager.getHistory());
    }
}