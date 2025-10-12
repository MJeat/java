public class TestGenericStack {
    public static void main(String[] args) {
        
        genericStack<Integer> myNumbers = new genericStack<>(4);
        
        System.out.println("=== INTEGER STACK TEST ===");
        myNumbers.push(10);
        myNumbers.push(20);
        myNumbers.push(30);
        myNumbers.push(40);
        
        // Display the entire stack
        myNumbers.display();
        
        /*
        Expected order after pushes:
        40 (top)
        30
        20
        10
        */
        
        System.out.println("\n--- Popping elements ---");
        System.out.println("Top: " + myNumbers.peek());
        myNumbers.pop();
        
        System.out.println("Top: " + myNumbers.peek()); 
        myNumbers.pop();
        
        System.out.println("Top: " + myNumbers.peek()); 
        myNumbers.pop();
        
        System.out.println("Top: " + myNumbers.peek()); 
        
        // Store the popped element
        Integer removedElement = myNumbers.pop();
        System.out.println("Removed element: " + removedElement); 
        
        // Test empty stack
        System.out.println("Top of empty stack: " + myNumbers.peek()); // null
        System.out.println("Size of empty stack: " + myNumbers.size()); // 0
        
        System.out.println("\n=== STRING STACK TEST ===");
        genericStack<String> nameList = new genericStack<>(3);
        nameList.push("John");
        nameList.push("Kim");
        
        nameList.display(); // Stack: [John, Kim]
        System.out.println("Top: " + nameList.peek()); // Kim
        
        // Test all required methods
        System.out.println("\n=== TESTING ALL REQUIRED METHODS ===");
        genericStack<Character> charStack = new genericStack<>(3);
        
        // Test push
        charStack.push('A');
        charStack.push('B');
        charStack.push('C');
        
        // Test display
        charStack.display(); // Stack: [A, B, C]
        
        // Test toString
        System.out.println("toString(): " + charStack.toString());
        
        // Test peek
        System.out.println("peek(): " + charStack.peek()); // C
        
        // Test pop
        System.out.println("pop(): " + charStack.pop()); // C
        charStack.display(); // Stack: [A, B]
        
        // Test isFull and isEmpty
        System.out.println("Is full? " + charStack.isFull()); // false
        System.out.println("Is empty? " + charStack.isEmpty()); // false
        
        // Clear stack and test isEmpty
        charStack.pop();
        charStack.pop();
        System.out.println("After clearing - Is empty? " + charStack.isEmpty()); // true
    }
}