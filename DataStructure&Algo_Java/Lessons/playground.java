import java.util.PriorityQueue;

public class playground {
    public static void main(String[] args) {
        // Create a priority queue
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        // Add tasks with priorities
        taskQueue.add(new Task(2, "Do homework"));
        taskQueue.add(new Task(1, "Eat lunch"));
        taskQueue.add(new Task(3, "Play video game"));

        // Remove tasks in order of priority (lowest number = highest priority)
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Priority: " + task.priority + " → Task: " + task.name);
        }
    }
}

// Create a Task class that implements Comparable
class Task implements Comparable<Task> {
    int priority;
    String name;

    public Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    // Define how to compare tasks (lower priority number comes first)
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}
