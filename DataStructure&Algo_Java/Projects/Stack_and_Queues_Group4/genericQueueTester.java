public class genericQueueTester {
    public static void main(String[] args) {
        System.out.println("=== QUEUE TESTER ===\n");
        
        // Test 1: Integer Queue
        System.out.println("1. INTEGER QUEUE:");
        Queue<Integer> intQueue = new Queue<>(3);
        intQueue.insert(10);
        intQueue.insert(20);
        intQueue.insert(30);
        intQueue.display();
        System.out.println("Front: " + intQueue.peekFront());
        System.out.println("Rear: " + intQueue.peekRear());
        System.out.println("Remove: " + intQueue.remove());
        intQueue.display();
        System.out.println();
        
        // Test 2: String Queue
        System.out.println("2. STRING QUEUE:");
        Queue<String> strQueue = new Queue<>(2);
        strQueue.insert("Hello");
        strQueue.insert("World");
        strQueue.display();
        System.out.println("Remove: " + strQueue.remove());
        System.out.println("Remove: " + strQueue.remove());
        System.out.println("Is empty: " + strQueue.isEmpty());
        System.out.println();
        
        // Test 3: Double Queue
        System.out.println("3. DOUBLE QUEUE:");
        Queue<Double> doubleQueue = new Queue<>(4);
        doubleQueue.insert(3.14);
        doubleQueue.insert(2.71);
        doubleQueue.insert(1.41);
        doubleQueue.display();
        System.out.println("toString: " + doubleQueue.toString());
        System.out.println();
        
        // Test 4: Boolean Queue
        System.out.println("4. BOOLEAN QUEUE:");
        Queue<Boolean> boolQueue = new Queue<>(2);
        boolQueue.insert(true);
        boolQueue.insert(false);
        boolQueue.display();
        System.out.println("Front: " + boolQueue.peekFront());
        System.out.println("Rear: " + boolQueue.peekRear());
        
        // Test 5: Error Cases
        System.out.println("\n5. ERROR TESTING:");
        Queue<Integer> testQueue = new Queue<>(1);
        testQueue.insert(99);
        try {
            testQueue.insert(100); // Should throw exception
        } catch (RuntimeException e) {
            System.out.println("Full queue error: " + e.getMessage());
        }
        
        testQueue.remove();
        try {
            testQueue.remove(); // Should throw exception
        } catch (RuntimeException e) {
            System.out.println("Empty queue error: " + e.getMessage());
        }
    }
}