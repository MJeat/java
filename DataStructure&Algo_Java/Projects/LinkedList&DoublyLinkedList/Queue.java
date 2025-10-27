// Queue.java
// Queue implementation using LinkedList (FIFO - First In, First Out)

public class Queue<T> {
    private LinkedList<T> list;

    // Constructor
    // O(1): Creates an empty queue using LinkedList.
    public Queue() {
        list = new LinkedList<>();
    }

    // Insert item at rear (FIFO)
    // O(n): insertLast() traverses the list to find the last node.
    public void insert(T newItem) {
        list.insertLast(newItem);
    }

    // Remove item from front
    // O(1): deleteFirst() removes the first node directly.
    public T remove() {
        if (list.isEmpty())
            throw new RuntimeException("Queue is empty");

        // The first element is always at the head
        T front = getFrontValue();
        list.deleteFirst();
        return front;
    }

    // Peek the front item
    // O(1): Returns first element without removing it.
    public T peekFront() {
        if (list.isEmpty())
            throw new RuntimeException("Queue is empty");
        return getFrontValue();
    }

    // Peek the rear item
    // O(n): Traverses through the LinkedList to find the last node.
    public T peekRear() {
        if (list.isEmpty())
            throw new RuntimeException("Queue is empty");

        Link<T> current = getHeadNode();
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    // Helper method to access the private head node in LinkedList using reflection
    // O(1): Reflection lookup only done once per call
    private Link<T> getHeadNode() {
        try {
            java.lang.reflect.Field field = LinkedList.class.getDeclaredField("head");
            field.setAccessible(true);
            return (Link<T>) field.get(list);
        } catch (Exception e) {
            throw new RuntimeException("Unable to access LinkedList head");
        }
    }

    // Helper to get the first node's data (front value)
    // O(1): Accesses head node directly.
    private T getFrontValue() {
        Link<T> headNode = getHeadNode();
        if (headNode == null)
            throw new RuntimeException("Queue is empty");
        return headNode.data;
    }

    // Check if queue is empty
    // O(1): Uses LinkedList's isEmpty() method.
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Display all elements
    // O(n): Iterates through the entire list to display each element.
    public void display() {
        System.out.print("Queue: ");
        list.display();
    }

    // Convert queue to string
    // O(n): Builds a string representation of the queue.
    public String toString() {
        return list.toString();
    }
}