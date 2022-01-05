package todoapplication;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Tasks {

  private String file = "src/todoapplication/tasks.txt";

  public Tasks() throws ApplicationException {
    Path path = Paths.get(this.file);
    try {
      List<String> taskStatus = Files.readAllLines(path);
    } catch (IOException e) {
      throw new ApplicationException("IO Exception in Manager", e);
    }
  }

  public int getListSize() throws ApplicationException {
    Path path = Paths.get(this.file);
    try {
      List<String> taskStatus = Files.readAllLines(path);
      return taskStatus.size();
    } catch (IOException e) {
      throw new ApplicationException("IO Exception in Manager", e);
    }

  }

  public void addTask(Task task) throws ApplicationException {
    Path path = Paths.get(this.file);
    try {
      List<String> taskStatus = Files.readAllLines(path);
      if (task.isDone()) {
        if (taskStatus.isEmpty()) {
          taskStatus.add("[X] " + task.getDescription());
          Files.write(Paths.get(this.file), taskStatus);
        } else {
          taskStatus.add("[X] " + task.getDescription());
          Writer output;
          output = new BufferedWriter(new FileWriter((this.file), true));
          output.append("[X] " + task.getDescription() + "\n");
          output.close();
        }
      } else {
        if (taskStatus.isEmpty()) {
          taskStatus.add("[_] " + task.getDescription());
          Files.write(Paths.get(this.file), taskStatus);
        } else {
          taskStatus.add("[_] " + task.getDescription());
          Writer output;
          output = new BufferedWriter(new FileWriter((this.file), true));
          output.append("[_] " + task.getDescription() + "\n");
          output.close();
        }
      }
    } catch (IOException e) {
      throw new ApplicationException("IO Exception in Manager", e);
    }
  }

  public void completeTask(int num) throws ApplicationException {
    Path path = Paths.get(this.file);
    try {
      List<String> taskStatus = Files.readAllLines(path);
      if (taskStatus.isEmpty()) {
        System.out.println("No todos for today! :)");
      } else {
        if (taskStatus.get(num - 1).contains("[_]")) {
          String newTask = taskStatus.get(num - 1).replace("_", "X");
          taskStatus.set(num - 1, newTask);
          Files.write(Paths.get(this.file), taskStatus);
        }
      }
    } catch (IOException e) {
      throw new ApplicationException("IO Exception in Manager", e);
    }
  }

  public void displayListOfTasks() throws ApplicationException {
    Path path = Paths.get(this.file);
    try {
      List<String> taskStatus = Files.readAllLines(path);
      if (taskStatus.isEmpty()) {
        System.out.println("No todos for today! :)");
      } else {
        for (int i = 0; i < taskStatus.size(); i++) {
          if (taskStatus.get(i).charAt(1) == '_') {
            System.out.println((i + 1) + " - " + "[ ]" + taskStatus.get(i).substring(3));
          } else {
            System.out.println((i + 1) + " - " + "[X]" + taskStatus.get(i).substring(3));
          }
        }
      }
    } catch (
        IOException e) {
      throw new ApplicationException("IO Exception in Manager", e);
    }
  }

  public void removeTask(int num) throws ApplicationException {
    Path path = Paths.get(this.file);
    try {
      List<String> taskStatus = Files.readAllLines(path);
      if (taskStatus.isEmpty()) {
        System.out.println("No todos for today! :)");
      } else {
        taskStatus.remove(num - 1);
        Files.write(Paths.get(this.file), taskStatus);
      }
    } catch (IOException e) {
      throw new ApplicationException("IO Exception in Manager", e);
    }
  }
}
