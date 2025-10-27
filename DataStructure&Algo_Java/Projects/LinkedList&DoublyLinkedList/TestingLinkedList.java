public class TestingLinkedList {
    public static void main(String[] args) {
        System.out.println("=== Testing LinkedList With Integers ===");
        withIntegers();

        System.out.println("\n=== Testing LinkedList With Doubles ===");
        withDoubles();

        System.out.println("\n=== Testing LinkedList With Strings ===");
        withStrings();
    }

    // Test with Integer data type
    public static void withIntegers() {
        LinkedList<Integer> integerList = new LinkedList<>();

        integerList.insertFirst(10);
        integerList.insertLast(20);
        integerList.insertLast(30);
        integerList.insertAt(15, 1);

        System.out.print("List after insertions: ");
        integerList.display();

        integerList.deleteAt(2);
        System.out.print("List after deleting index 2: ");
        integerList.display();

        integerList.deleteKey(15);
        System.out.print("List after deleting key 15: ");
        integerList.display();

        System.out.println("Find 30: " + integerList.find(30));
        System.out.println("Is list empty? " + integerList.isEmpty());
    }

    // Test with Double data type
    public static void withDoubles() {
        LinkedList<Double> doubleList = new LinkedList<>();

        doubleList.insertFirst(1.1);
        doubleList.insertLast(2.2);
        doubleList.insertLast(3.3);
        doubleList.insertAt(4.4, 2);

        System.out.print("List after insertions: ");
        doubleList.display();

        doubleList.deleteAt(1);
        System.out.print("List after deleting index 1: ");
        doubleList.display();

        doubleList.deleteKey(4.4);
        System.out.print("List after deleting key 4.4: ");
        doubleList.display();

        System.out.println("Find 3.3: " + doubleList.find(3.3));
        System.out.println("Is list empty? " + doubleList.isEmpty());
    }

    // Test with String data type
    public static void withStrings() {
        LinkedList<String> stringList = new LinkedList<>();

        stringList.insertFirst("Alice");
        stringList.insertLast("Bob");
        stringList.insertLast("Charlie");
        stringList.insertAt("Diana", 1);

        System.out.print("List after insertions: ");
        stringList.display();

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
