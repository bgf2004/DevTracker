import java.util.*;

public class TaskManager{
    private PriorityQueue<Task> tasks = new PriorityQueue<>();
    private int nextID = 1;

    public void addTask(String title, Priority priority){
        tasks.add(new Task(nextID, title, priority));
        nextID++;
    }

    public boolean completeTask(int id){
        boolean found = false;
        for(Task task : tasks){
            if(task.getTaskID() == id && !task.isDone()){
                task.markDone();
                found = true;
            }
        }
        if(!found){
            System.out.println("There is no task with ID: " + id);
        }
        return found;
    }

    public void listTasks(){
        List<Task> sortedList = new ArrayList<>(tasks);
        Collections.sort(sortedList);
        for(Task task : sortedList){
            System.out.println(task.toString());
        }
    }

}
