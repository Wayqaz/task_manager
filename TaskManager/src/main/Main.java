package main;

import tasks.Epic;
import tasks.Subtask;
import tasks.Task;

public class Main {
    public static Manager manager = new Manager();

    public static void main(String[] args) {
        Task newTask = new Task("12", "1233");
        Epic newEpic = new Epic("12", "123123");
        Subtask subtask = new Subtask("14", "1444", newEpic.hashCode());
        System.out.println(newEpic.getCollectionSubtask());
        System.out.println(manager.getCollectionEpic() + "\n" + manager.getCollectionSubtask() + "\n" +
                manager.getCollectionTask());
    }
}