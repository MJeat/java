// TestingQueueUsingLinkedList.java
// Short and clean version — tests Queue using LinkedList with multiple data types

public class TestingQueueUsingLinkedList {
    public static void main(String[] args) {
        System.out.println("=== Testing Queue with Strings ===");
        withStrings();

        System.out.println("\n=== Testing Queue with Integers ===");
        withIntegers();

        System.out.println("\n=== Testing Queue with Doubles ===");
        withDouble();
    }

    // Generic testing helper method
    private static <T> void testQueue(Queue<T> queue, T... items) { // The "..." part is called a varargs parameter — short for variable-length arguments. It accepts any number of arguments of type T
        System.out.println("Inserting elements...");
        for (T item : items) queue.insert(item);
        queue.display();

        System.out.println("Front: " + queue.peekFront() + " | Rear: " + queue.peekRear());

        System.out.println("\nRemoving one element...");
        queue.remove();
        queue.display();

        System.out.println("Front: " + queue.peekFront() + " | Rear: " + queue.peekRear());
        System.out.println("Is empty? " + queue.isEmpty());

        System.out.println("\nClearing queue...");
        while (!queue.isEmpty()) queue.remove();
        queue.display();
        System.out.println("Empty now? " + queue.isEmpty());
    }

    // Test with Strings
    public static void withStrings() {
        Queue<String> stringQueue = new Queue<>();
        testQueue(stringQueue, "A", "B", "C");
    }

    // Test with Integers
    public static void withIntegers() {
        Queue<Integer> integerQueue = new Queue<>();
        testQueue(integerQueue, 3, 4, 8);
    }

    // Test with Doubles
    public static void withDouble() {
        Queue<Double> doubleQueue = new Queue<>();
        testQueue(doubleQueue, 1.1, 2.5, 3.7);
    }
}
