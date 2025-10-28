import java.util.Iterator;

public class TestingLinkedList {
    public static void main(String[] args) {
        System.out.println("=== Testing Singly LinkedList With Integers ===");
        withIntegers();

        System.out.println("\n=== Testing Singly LinkedList With Doubles ===");
        withDoubles();

        System.out.println("\n=== Testing Singly LinkedList With Strings ===");
        withStrings();
    }

    // ===== INTEGER TEST =====
    public static void withIntegers() {
        SinglyLinkedList<Integer> integerList = new SinglyLinkedList<>();

        // --- Insert operations ---
        integerList.insertFirst(10);
        integerList.insertLast(20);
        integerList.insertLast(30);
        integerList.insertAt(15, 1);

        System.out.print("List after insertions: ");
        integerList.display();

        // --- Iterator test using for-each loop ---
        System.out.print("Iterating with for-each: ");
        for (Integer num : integerList) {
            System.out.print(num + " ");
        }
        System.out.println();

        // --- Iterator test using manual iterator ---
        System.out.print("Iterating manually using Iterator: ");
        Iterator<Integer> it = integerList.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // --- Deletion operations ---
        integerList.deleteAt(2);
        System.out.print("List after deleting index 2: ");
        integerList.display();

        integerList.deleteKey(15);
        System.out.print("List after deleting key 15: ");
        integerList.display();

        // --- Other checks ---
        System.out.println("Find 30: " + integerList.find(30));
        System.out.println("Is list empty? " + integerList.isEmpty());
    }

    // ===== DOUBLE TEST =====
    public static void withDoubles() {
        SinglyLinkedList<Double> doubleList = new SinglyLinkedList<>();

        doubleList.insertFirst(1.1);
        doubleList.insertLast(2.2);
        doubleList.insertLast(3.3);
        doubleList.insertAt(4.4, 2);

        System.out.print("List after insertions: ");
        doubleList.display();

        // --- Iterator test ---
        System.out.print("Iterating with for-each: ");
        for (Double val : doubleList) {
            System.out.print(val + " ");
        }
        System.out.println();

        doubleList.deleteAt(1);
        System.out.print("List after deleting index 1: ");
        doubleList.display();

        doubleList.deleteKey(4.4);
        System.out.print("List after deleting key 4.4: ");
        doubleList.display();

        System.out.println("Find 3.3: " + doubleList.find(3.3));
        System.out.println("Is list empty? " + doubleList.isEmpty());
    }

    // ===== STRING TEST =====
    public static void withStrings() {
        SinglyLinkedList<String> stringList = new SinglyLinkedList<>();

        stringList.insertFirst("Alice");
        stringList.insertLast("Bob");
        stringList.insertLast("Charlie");
        stringList.insertAt("Diana", 1);

        System.out.print("List after insertions: ");
        stringList.display();

        // --- Iterator test ---
        System.out.print("Iterating with for-each: ");
        for (String name : stringList) {
            System.out.print(name + " ");
        }
        System.out.println();

        stringList.deleteAt(2);
        System.out.print("List after deleting index 2: ");
        stringList.display();

        stringList.deleteKey("Diana");
        System.out.print("List after deleting key 'Diana': ");
        stringList.display();

        System.out.println("Find 'Charlie': " + stringList.find("Charlie"));
        System.out.println("Is list empty? " + stringList.isEmpty());
    }
}
