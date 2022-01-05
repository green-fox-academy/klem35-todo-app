package todoapplication;

public class Main {
  public static void main(String[] args) throws ApplicationException {
    Tasks tasks = new Tasks();

    if (args.length == 0) {

      System.out.println("Command line arguments:");
      System.out.println("\t -l   Lists all the tasks");
      System.out.println("\t -a   Adds a new task");
      System.out.println("\t -r   Removes a task");
      System.out.println("\t -c   Completes a task");

    } else if (args[0].equals("-l")) {
      tasks.displayListOfTasks();
    } else if (args[0].equals("-a")) {
      try {
        Task task = new Task(args[1]);
        tasks.addTask(task);
      } catch (Exception e) {
        throw new ApplicationException("Unable to add: no task provided", e);
      }
    } else if (args[0].equals("-c")) {
      try {
        tasks.completeTask(Integer.parseInt(args[1]));
      } catch (Exception e) {
        throw new ApplicationException("Unable to check: no index provided", e);
      }
    } else if (args[0].equals("-r")) {
      try {
        tasks.removeTask(Integer.parseInt(args[1]));
      } catch (NumberFormatException e) {
        System.err.println("Unable to remove: index is not a number");
      } catch (NullPointerException e) {
        System.err.println("Unable to check: no index provided");
      } catch (IndexOutOfBoundsException e) {
        System.err.println("Unable to remove: index is out of bound");
      }
    } else if (args[0] != "-l" &&
        args[0] != "-a" &&
        args[0] != "-r" &&
        args[0] != "-c") {
      System.err.println("Unsupported argument");
      System.out.println("Command line arguments:");
      System.out.println("\t -l   Lists all the tasks");
      System.out.println("\t -a   Adds a new task");
      System.out.println("\t -r   Removes a task");
      System.out.println("\t -c   Completes a task");
    }
  }
}


