package utility;

import tasks.*;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;

import static main.Main.historyManager;
import static main.Main.taskManager;

public class InFileTaskManager extends InMemoryTaskManager {

    private final Path saveFile;

    public InFileTaskManager(Path saveFile) {
        this.saveFile = saveFile;
        String[] data;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(saveFile.toString()))) {
            bufferedReader.readLine();
            data = bufferedReader.readLine().split(",");
            do {
                switch (TypeTask.valueOf(data[1])) {
                    case TASK -> new Task(Integer.parseInt(data[0]), data[2], Status.valueOf(data[3]), data[4]);
                    case EPIC -> new Epic(Integer.parseInt(data[0]), data[2], Status.valueOf(data[3]), data[4]);
                    case SUBTASK -> new Subtask(Integer.parseInt(data[0]), data[2], Status.valueOf(data[3]), data[4],
                            (Epic) taskManager.silentGetElement(Integer.parseInt(data[5])));
                }
                System.out.printf("%s,%s,%s,%s,%s\n", data[0], data[1], data[2], data[3], data[4]);
                data = bufferedReader.readLine().split(",");
            } while (data.length != 1);
            data = bufferedReader.readLine().split(",");
            for (String element : data) {
                historyManager.add(taskManager.silentGetElement(Integer.parseInt(element)));
            }
        } catch (FileNotFoundException e) {
            System.out.println("ОШИБКА: Файл не найден");
        } catch (NullPointerException e) {
            System.out.println("ОШИБКА: Файл пуст");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save() {
        try (FileWriter writer = new FileWriter(saveFile.toString())) {
            writer.write("id,type,name,status,description,epic");
            for (Task value : taskManager.getCollectionTask().values()) {
                writer.write("\n" + value.toString());
            }
            for (Epic value : taskManager.getCollectionEpic().values()) {
                writer.write("\n" + value.toString());
            }
            for (Subtask value : taskManager.getCollectionSubtask().values()) {
                writer.write("\n" + value.toString());
            }
            writer.write("\n\n");
            for (int i = 0; i < historyManager.getHistory().size(); i++) {
                writer.write(String.valueOf(historyManager.getHistory().get(i).getId()));
                if (i < historyManager.getHistory().size() - 1) writer.write(",");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <E extends Task> void deleteCollectionElement(E element) {
        taskManager.deleteCollectionElement(element);
        save();
    }

    @Override
    public void deleteCollectionElement(TypeTask type, int id) {
        taskManager.deleteCollectionElement(type, id);
        save();
    }

    @Override
    public <E extends Task> void updateCollectionElement(E element) {
        taskManager.updateCollectionElement(element);
        save();
    }

    @Override
    public void cleanCollection(TypeTask type) {
        taskManager.cleanCollection(type);
        save();
    }

    @Override
    public Task getTask(int id) {
        Task task = taskManager.getTask(id);
        save();
        return task;
    }

    @Override
    public Subtask getSubtask(int id) {
        Subtask subtask = taskManager.getSubtask(id);
        save();
        return subtask;
    }

    @Override
    public Epic getEpic(int id) {
        Epic epic = taskManager.getEpic(id);
        save();
        return epic;
    }

    @Override
    public HashMap<Integer, Task> getCollectionTask() {
        return taskManager.getCollectionTask();
    }

    @Override
    public HashMap<Integer, Subtask> getCollectionSubtask() {
        return taskManager.getCollectionSubtask();
    }

    @Override
    public HashMap<Integer, Epic> getCollectionEpic() {
        return taskManager.getCollectionEpic();
    }
}
