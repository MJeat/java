

public class TestingDoublyLinkedList {
    public static void main(String[] args) {
        System.out.println("===Testing Doubly LinkedList With Integers===");
        withIntegers();

        System.out.println("\n===Testing Doubly LinkedList With Doubles===");
        withDouble();

        System.out.println("\n===Testing Doubly LinkedList With Strings===");
        withStrings();
        
    }

    public static void withIntegers(){

        DoublyLinkedList<Integer> integerDoublyList = new DoublyLinkedList<>();
        // Test insertions
        integerDoublyList.insertFirst(10);
        integerDoublyList.insertLast(30);
        integerDoublyList.insertFirst(5);
        integerDoublyList.insertAt(1);
        
        // Display lists
        integerDoublyList.displayForward();   
        integerDoublyList.displayBackward();  
        
        // Test deletions
        integerDoublyList.deleteFirst();     
        integerDoublyList.deleteLast();      
        integerDoublyList.deleteKey(10);     
        
        System.out.println("The Integer List contains: "+integerDoublyList.toString()); 
        System.out.println("Is empty: " + integerDoublyList.isEmpty()); 
        System.out.println("Find 5." + " It's at index: "+ integerDoublyList.find(5)); 
    }

    public static void withDouble(){
        DoublyLinkedList<Double> doubleDoublyList = new DoublyLinkedList<>();

        // Test insertions
        doubleDoublyList.insertFirst(10.2);
        doubleDoublyList.insertLast(30.3);
        doubleDoublyList.insertLast(23.3);
        doubleDoublyList.insertFirst(5.4);
        doubleDoublyList.insertAt(0.2);
        
        // Display lists
        doubleDoublyList.displayForward();   
        doubleDoublyList.displayBackward();  
        
        // Test deletions
        doubleDoublyList.deleteFirst();     
        doubleDoublyList.deleteLast();      
        doubleDoublyList.deleteKey(10.2);     
        
        System.out.println("The Double List contains: "+doubleDoublyList.toString()); 
        System.out.println("Is empty: " + doubleDoublyList.isEmpty()); 
        System.out.println("\nFind 5.4" + "\nIt's at index: "+ doubleDoublyList.find(5.4)); 
    }

    public static void withStrings(){
        DoublyLinkedList<String> stringDoublyList = new DoublyLinkedList<>();
         // Test insertions
        stringDoublyList.insertFirst("Bob");
        stringDoublyList.insertLast("John");
        stringDoublyList.insertFirst("Alice");
        stringDoublyList.insertAt("Alex");
        
        // Display lists
        stringDoublyList.displayForward();   
        stringDoublyList.displayBackward();  
        
        // Test deletions
        stringDoublyList.deleteFirst();     
        stringDoublyList.deleteLast();      
        stringDoublyList.deleteKey("Alex");     
        
        System.out.println("The String List contains: "+stringDoublyList.toString()); 
        System.out.println("Is empty: " + stringDoublyList.isEmpty()); 
        System.out.println("Find Bob." + "It's at index: "+ stringDoublyList.find("Bob")); 
    }
}