public class TestingStackUsingLinkedList {
    public static void main(String[] args) {

        System.out.println("=== Testing Stack With Integers ===");
        withIntegers();

        System.out.println("\n=== Testing Stack With Doubles ===");
        withDoubles();

        System.out.println("\n=== Testing Stack With Strings ===");
        withStrings();
    }

    public static void withIntegers() {
        Stack<Integer> integerStack = new Stack<>();

        integerStack.push(100);
        integerStack.push(200);
        integerStack.push(300);

        System.out.print("Current Stack: ");
        integerStack.display();

        System.out.println("Peek top: " + integerStack.peek());
        System.out.println("Pop top: " + integerStack.pop());

        System.out.print("Stack after pop: ");
        integerStack.display();

        System.out.println("Is stack empty? " + integerStack.isEmpty());
    }

    public static void withDoubles() {
        Stack<Double> doubleStack = new Stack<>();

        doubleStack.push(1.1);
        doubleStack.push(2.2);
        doubleStack.push(3.3);

        System.out.print("Current Stack: ");
        doubleStack.display();

        System.out.println("Peek top: " + doubleStack.peek());
        System.out.println("Pop top: " + doubleStack.pop());

        System.out.print("Stack after pop: ");
        doubleStack.display();

        System.out.println("Is stack empty? " + doubleStack.isEmpty());
    }

    public static void withStrings() {
        Stack<String> stringStack = new Stack<>();

        stringStack.push("Alice");
        stringStack.push("Bob");
        stringStack.push("Charlie");

        System.out.print("Current Stack: ");
        stringStack.display();

        System.out.println("Peek top: " + stringStack.peek());
        System.out.println("Pop top: " + stringStack.pop());

        System.out.print("Stack after pop: ");
        stringStack.display();

        System.out.println("Is stack empty? " + stringStack.isEmpty());
    }
}
