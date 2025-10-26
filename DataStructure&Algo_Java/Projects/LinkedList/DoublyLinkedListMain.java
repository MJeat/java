public class DoublyLinkedListMain {
    public static void main(String[] args) {
        System.out.println("===Testing Doubly LinkedList With Integers===");
        withIntegers();

        System.out.println("\n===Testing Doubly LinkedList With Doubles===");
        withDouble();

        System.out.println("\n===Testing Doubly LinkedList With Strings===");
        withStrings();
        
    }

    public static void withIntegers(){

        DoublyLinkedList<Integer> stringList = new DoublyLinkedList<>();
        // Test insertions
        stringList.insertFirst(10);
        stringList.insertLast(30);
        stringList.insertFirst(5);
        stringList.insertAt(1);
        
        // Display lists
        stringList.displayForward();   
        stringList.displayBackward();  
        
        // Test deletions
        stringList.deleteFirst();     
        stringList.deleteLast();      
        stringList.deleteKey(10);     
        
        System.out.println("The Integer List contains: "+stringList.toString()); 
        System.out.println("Is empty: " + stringList.isEmpty()); 
        System.out.println("Find 5." + " It's at index: "+ stringList.find(5)); 
    }

    public static void withDouble(){
        DoublyLinkedList<Double> stringList = new DoublyLinkedList<>();

        // Test insertions
        stringList.insertFirst(10.2);
        stringList.insertLast(30.3);
        stringList.insertLast(23.3);
        stringList.insertFirst(5.4);
        stringList.insertAt(0.2);
        
        // Display lists
        stringList.displayForward();   
        stringList.displayBackward();  
        
        // Test deletions
        stringList.deleteFirst();     
        stringList.deleteLast();      
        stringList.deleteKey(10.2);     
        
        System.out.println("The Double List contains: "+stringList.toString()); 
        System.out.println("Is empty: " + stringList.isEmpty()); 
        System.out.println("\nFind 5.4" + "\nIt's at index: "+ stringList.find(5.4)); 
    }

    public static void withStrings(){
        DoublyLinkedList<String> stringList = new DoublyLinkedList<>();
         // Test insertions
        stringList.insertFirst("Bob");
        stringList.insertLast("John");
        stringList.insertFirst("Alice");
        stringList.insertAt("Alex");
        
        // Display lists
        stringList.displayForward();   
        stringList.displayBackward();  
        
        // Test deletions
        stringList.deleteFirst();     
        stringList.deleteLast();      
        stringList.deleteKey("Alex");     
        
        System.out.println("The String List contains: "+stringList.toString()); 
        System.out.println("Is empty: " + stringList.isEmpty()); 
        System.out.println("Find Bob." + "It's at index: "+ stringList.find("Bob")); 
    }
}