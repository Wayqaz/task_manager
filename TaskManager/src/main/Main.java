package main;

import tasks.Epic;
import tasks.Subtask;
import tasks.Task;
import utility.InFileTaskManager;
import utility.InMemoryHistoryManager;
import utility.InMemoryTaskManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static InMemoryTaskManager taskManager = new InMemoryTaskManager();
    public static InMemoryHistoryManager historyManager = new InMemoryHistoryManager();
    public static InFileTaskManager inFileTaskManager= new InFileTaskManager(Path.of("C:\\Users\\LENOVO\\dev" +
            "\\Sprint 2\\TaskManager\\Data\\data.csv"));

    public static void main(String[] args) {
        System.out.println();
        for (Task task : historyManager.getHistory()) {
            System.out.println(task);
        }
    }
}