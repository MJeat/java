public class genericStackTester {
    public static void main(String[] args) {
        System.out.println("=== STACK CLASS COMPREHENSIVE TEST ===\n");
        
        // Test 1: Basic Integer Stack Operations
        testIntegerStack();
        
        // Test 2: String Stack Operations
        testStringStack();
        
        // Test 3: Edge Cases and Error Handling
        testEdgeCases();
        
        // Test 4: Mixed Data Types
        testMixedTypes();
        
        System.out.println("\n=== ALL TESTS COMPLETED ===");
    }
    
    public static void testIntegerStack() {
        System.out.println("--- TEST 1: INTEGER STACK ---");
        Stack<Integer> intStack = new Stack<>(5);
        
        // Test push and display
        System.out.println("Pushing numbers 10, 20, 30, 40...");
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.push(40);
        intStack.display(); // Stack: [10, 20, 30, 40]
        
        // Test peek
        System.out.println("Peek: " + intStack.peek()); // 40
        
        // Test pop
        System.out.println("Pop: " + intStack.pop()); // 40
        System.out.println("After pop:");
        intStack.display(); // Stack: [10, 20, 30]
        
        // Test multiple pops
        System.out.println("Pop: " + intStack.pop()); // 30
        System.out.println("Pop: " + intStack.pop()); // 20
        System.out.println("After multiple pops:");
        intStack.display(); // Stack: [10]
        
        // Test toString
        System.out.println("toString(): " + intStack.toString()); // [10]
        
        // Clear stack
        System.out.println("Final pop: " + intStack.pop()); // 10
        System.out.println("Is empty: " + intStack.isEmpty()); // true
        System.out.println();
    }
    
    public static void testStringStack() {
        System.out.println("--- TEST 2: STRING STACK ---");
        Stack<String> stringStack = new Stack<>(3);
        
        // Test push with strings
        System.out.println("Pushing names...");
        stringStack.push("Alice");
        stringStack.push("Bob");
        stringStack.push("Charlie");
        stringStack.display(); // Stack: [Alice, Bob, Charlie]
        
        // Test LIFO behavior
        System.out.println("Demonstrating LIFO (Last-In-First-Out):");
        while (!stringStack.isEmpty()) {
            System.out.println("Popped: " + stringStack.pop());
        }
        // Output: Charlie, Bob, Alice
        System.out.println();
    }
    
    public static void testEdgeCases() {
        System.out.println("--- TEST 3: EDGE CASES ---");
        Stack<Integer> edgeStack = new Stack<>(2);
        
        // Test empty stack operations
        System.out.println("Testing empty stack:");
        System.out.println("Is empty: " + edgeStack.isEmpty()); // true
        
        try {
            edgeStack.peek(); // This should throw exception
        } catch (RuntimeException e) {
            System.out.println("Expected error - peek on empty: " + e.getMessage());
        }
        
        try {
            edgeStack.pop(); // This should throw exception
        } catch (RuntimeException e) {
            System.out.println("Expected error - pop on empty: " + e.getMessage());
        }
        
        // Test full stack
        System.out.println("\nTesting full stack:");
        edgeStack.push(100);
        edgeStack.push(200);
        System.out.println("Stack after pushing 2 items:");
        edgeStack.display(); // Stack: [100, 200]
        
        try {
            edgeStack.push(300); // This should throw exception
        } catch (RuntimeException e) {
            System.out.println("Expected error - push on full: " + e.getMessage());
        }
        
        System.out.println();
    }
    
    public static void testMixedTypes() {
        System.out.println("--- TEST 4: MIXED DATA TYPES ---");
        
        // Test with Double
        System.out.println("Double Stack:");
        Stack<Double> doubleStack = new Stack<>(3);
        doubleStack.push(3.14);
        doubleStack.push(2.71);
        doubleStack.push(1.41);
        doubleStack.display();
        System.out.println("Peek: " + doubleStack.peek());
        
        // Test with Character
        System.out.println("\nCharacter Stack:");
        Stack<Character> charStack = new Stack<>(4);
        charStack.push('A');
        charStack.push('B');
        charStack.push('C');
        charStack.push('D');
        charStack.display();
        
        // Demonstrate LIFO with characters
        System.out.print("Popping all: ");
        while (!charStack.isEmpty()) {
            System.out.print(charStack.pop() + " ");
        }
        System.out.println(); // Output: D C B A
        
        // Test with Boolean
        System.out.println("\nBoolean Stack:");
        Stack<Boolean> boolStack = new Stack<>(2);
        boolStack.push(true);
        boolStack.push(false);
        boolStack.display();
        System.out.println("Popped: " + boolStack.pop()); // false
        System.out.println("Popped: " + boolStack.pop()); // true
    }
}