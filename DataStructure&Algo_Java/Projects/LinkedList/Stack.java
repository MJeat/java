public class Stack<T> {
    private LinkedList<T> list;

    // Constructor – O(1)
    public Stack() {
        list = new LinkedList<>();
    }

    // Check if stack is empty – O(1)
    public boolean isEmpty() {
        return false;
    }

    // Display all elements – O(n)
    public void display() {
        list.display();
    }

    // Push (insert at top) – O(1)
    public void push(T item) {
        list.insertFirst(item); 
    }

    // Pop (remove from top) – O(1)
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        T topItem = peek();
        list.deleteFirst();
        return topItem;
    }

    // Peek (view top element) – O(1)
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        try {
            // Using reflection to access private 'head' field in LinkedList
            java.lang.reflect.Field headField = list.getClass().getDeclaredField("head");
            headField.setAccessible(true);
            Object head = headField.get(list);
            if (head == null) return null;

            // This is to access 'data' field from Link class
            java.lang.reflect.Field dataField = head.getClass().getDeclaredField("data");
            dataField.setAccessible(true);
            return (T) dataField.get(head);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
