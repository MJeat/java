public class genericPriorityQueueTester {
    public static void main(String[] args) {
        System.out.println("=== PRIORITY QUEUE TEST ===\n");
        
        // Test 1: Integer Priority Queue
        System.out.println("1. INTEGER PRIORITY QUEUE:");
        PriorityQueue<Integer> pq = new PriorityQueue<>(5);
        
        pq.insert(10, 1);  // Low priority
        pq.insert(20, 3);  // Medium priority  
        pq.insert(30, 5);  // High priority
        pq.insert(40, 2);  // Medium-low priority
        pq.display();
        
        System.out.println("Peek Front (highest priority): " + pq.peekFront()); 
        System.out.println("Peek Rear (lowest priority): " + pq.peekRear());    
        
        System.out.println("Remove: " + pq.remove()); 
        System.out.println("Remove: " + pq.remove()); 
        pq.display();
        System.out.println();
        
        // Test 2: String Priority Queue
        System.out.println("2. STRING PRIORITY QUEUE:");
        PriorityQueue<String> strPQ = new PriorityQueue<>(4);
        
        strPQ.insert("Low urgency", 1);
        strPQ.insert("High urgency", 10);
        strPQ.insert("Medium urgency", 5);
        strPQ.display();
        
        System.out.println("Front: " + strPQ.peekFront()); // High urgency
        System.out.println("Remove: " + strPQ.remove());   // High urgency
        System.out.println("New Front: " + strPQ.peekFront()); // Medium urgency
        System.out.println();
        
        // Test 3: Error Cases
        System.out.println("3. ERROR TESTING:");
        PriorityQueue<Boolean> smallPQ = new PriorityQueue<>(1);
        smallPQ.insert(true, 5);
        
        try {
            smallPQ.insert(false, 3); // Should throw exception
        } catch (RuntimeException e) {
            System.out.println("Full queue error: " + e.getMessage());
        }
        
        smallPQ.remove();
        try {
            smallPQ.remove(); // Should throw exception
        } catch (RuntimeException e) {
            System.out.println("Empty queue error: " + e.getMessage());
        }
    }
}