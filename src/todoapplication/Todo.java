package todoapplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Todo {

    private List<String> listOfTasks;
    private String file;

    public Todo(String file) throws ApplicationException {
        this.file = file;
        Path path = Paths.get(file);
        try {
            this.listOfTasks = Files.readAllLines(path);
        } catch (IOException e) {
            throw new ApplicationException("IO Exception in Manager", e);
        }
    }

    public void addTask(Task task) throws ApplicationException {
        Path path = Paths.get(this.file);
        try {
            this.listOfTasks = Files.readAllLines(path);
            this.listOfTasks.add(task.getDescription());
            Files.write(Paths.get(this.file), this.listOfTasks);
        } catch (IOException e) {
            throw new ApplicationException("IO Exception in Manager", e);
        }
    }

    public void displayListOfTasks() throws ApplicationException {
        Path path = Paths.get(this.file);
        try {
            this.listOfTasks = Files.readAllLines(path);
            if (this.listOfTasks.isEmpty()) {
                System.out.println("No todos for today! :)");
            } else {
                for (int i = 1; i <= this.listOfTasks.size(); i++) {
                    System.out.println(i + " - " + this.listOfTasks.get(i - 1));
                }
            }
        } catch (IOException e) {
            throw new ApplicationException("IO Exception in Manager", e);
        }
    }

    public List<String> getListOfTasks() throws ApplicationException {
        Path path = Paths.get(this.file);
        try {
            this.listOfTasks = Files.readAllLines(path);
            return this.listOfTasks;
        } catch (IOException e) {
            throw new ApplicationException("IO Exception in Manager", e);
        }
    }

    public void checkTask(int num) throws ApplicationException {
        Path path = Paths.get(this.file);
        try {
            this.listOfTasks = Files.readAllLines(path);
            if (this.listOfTasks.isEmpty()) {
                System.out.println("No todos for today! :)");
            } else {
                System.out.println(this.listOfTasks.get(num - 1));
            }
        } catch (IOException e) {
            throw new ApplicationException("IO Exception in Manager", e);
        }
    }

    public String getFile() {
        return file;
    }

}
