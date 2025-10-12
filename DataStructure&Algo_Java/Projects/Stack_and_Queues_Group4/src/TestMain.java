public class TestMain {
    public static void main(String[] args) {
        // Stack test
        Stack<Integer> stack = new Stack<>(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);
        System.out.println("Popped: " + stack.pop());
        stack.display();
        // Queue test
        Queue<String> queue = new Queue<>(5);
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        System.out.println("Queue: " + queue);
        System.out.println("Removed: " + queue.remove());
        queue.display();
    }
}