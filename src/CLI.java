import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        TaskManager task = new TaskManager();
        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to TaskManager!\n");
        while(true){
            System.out.println("Enter a command - add, list, complete, exit: ");
            String input = scnr.nextLine().trim().toLowerCase();

            if(input.equals("add")){
                System.out.println("Title of the task: ");
                String title = scnr.nextLine().trim();
                System.out.println("Priority (HIGH/MEDIUM/LOW): ");
                Priority priority = Priority.valueOf(scnr.nextLine().trim().toUpperCase());
                task.addTask(title, priority);
                System.out.println("Task added\n");

            } else if (input.equals("list")) {
                task.listTasks();

            } else if (input.equals("complete")) {
                System.out.println("Enter ID of task: ");
                int id = scnr.nextInt();
                scnr.nextLine();
                if(task.completeTask(id)) {
                    System.out.println("Task " + id + " marked as finished\n");
                }

            } else if (input.equals("exit")) {
                System.out.println("Goodbye!");
                return;
            }else {
                System.out.println("Invalid command choose from: add, list, complete, exit: ");
            }
        }
    }
}
