import java.util.Iterator;

public class TestDoublyLinkedList {
    public static void main(String[] args) {
        System.out.println("=== Testing Doubly LinkedList With Integers ===");
        withIntegers();

        System.out.println("\n=== Testing Doubly LinkedList With Doubles ===");
        withDoubles();

        System.out.println("\n=== Testing Doubly LinkedList With Strings ===");
        withStrings();
    }

    // ===== INTEGER TEST =====
    public static void withIntegers() {
        DoublyLinkedList<Integer> integerDoublyList = new DoublyLinkedList<>();

        // Test insertions
        integerDoublyList.insertFirst(10);
        integerDoublyList.insertLast(30);
        integerDoublyList.insertFirst(5);
        integerDoublyList.insertAt(1);

        System.out.println("\nDisplay forward:");
        integerDoublyList.displayForward();

        System.out.println("Display backward:");
        integerDoublyList.displayBackward();

        // === Iterator Test (for-each loop) ===
        System.out.print("Iterating with for-each loop: ");
        for (Integer val : integerDoublyList) {
            System.out.print(val + " ");
        }
        System.out.println();

        // === Iterator Test (manual iterator) ===
        System.out.print("Iterating manually using Iterator: ");
        Iterator<Integer> it = integerDoublyList.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Test deletions
        integerDoublyList.deleteFirst();
        integerDoublyList.deleteLast();
        integerDoublyList.deleteKey(10);

        System.out.println("The Integer List contains: " + integerDoublyList.toString());
        System.out.println("Is empty: " + integerDoublyList.isEmpty());
        System.out.println("Find 5 → at index: " + integerDoublyList.find(5));
    }

    // ===== DOUBLE TEST =====
    public static void withDoubles() {
        DoublyLinkedList<Double> doubleDoublyList = new DoublyLinkedList<>();

        doubleDoublyList.insertFirst(10.2);
        doubleDoublyList.insertLast(30.3);
        doubleDoublyList.insertLast(23.3);
        doubleDoublyList.insertFirst(5.4);
        doubleDoublyList.insertAt(0.2);

        doubleDoublyList.displayForward();
        doubleDoublyList.displayBackward();

        // === Iterator Test ===
        System.out.print("Iterating using for-each: ");
        for (Double d : doubleDoublyList) {
            System.out.print(d + " ");
        }
        System.out.println();

        doubleDoublyList.deleteFirst();
        doubleDoublyList.deleteLast();
        doubleDoublyList.deleteKey(10.2);

        System.out.println("The Double List contains: " + doubleDoublyList.toString());
        System.out.println("Is empty: " + doubleDoublyList.isEmpty());
        System.out.println("Find 5.4 → at index: " + doubleDoublyList.find(5.4));
    }

    // ===== STRING TEST =====
    public static void withStrings() {
        DoublyLinkedList<String> stringDoublyList = new DoublyLinkedList<>();

        stringDoublyList.insertFirst("Bob");
        stringDoublyList.insertLast("John");
        stringDoublyList.insertFirst("Alice");
        stringDoublyList.insertAt("Alex");

        stringDoublyList.displayForward();
        stringDoublyList.displayBackward();

        // === Iterator Test ===
        System.out.print("Iterating using for-each: ");
        for (String name : stringDoublyList) {
            System.out.print(name + " ");
        }
        System.out.println();

        stringDoublyList.deleteFirst();
        stringDoublyList.deleteLast();
        stringDoublyList.deleteKey("Alex");

        System.out.println("The String List contains: " + stringDoublyList.toString());
        System.out.println("Is empty: " + stringDoublyList.isEmpty());
        System.out.println("Find Bob → at index: " + stringDoublyList.find("Bob"));
    }
}
