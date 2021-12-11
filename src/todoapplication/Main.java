package todoapplication;

public class Main {
    public static void main(String[] args) {

        Todo todo = new Todo("src/todoapplication/tasks.txt");

        System.out.println("Command line arguments:");
        System.out.println("\t -l   Lists all the tasks");
        System.out.println("\t -a   Adds a new task");
        System.out.println("\t -r   Removes a task");
        System.out.println("\t -c   Completes a task");

        if (args[0].equals("-l")) {
            todo.getListOfTasks();
        } else if (args[0].equals("-a")) {
            try {
                Task task = new Task(args[1]);
                todo.addTask(task);
            } catch (Exception e) {
                System.err.println("Unable to add: no task provided");
            }
        }
    }
}
