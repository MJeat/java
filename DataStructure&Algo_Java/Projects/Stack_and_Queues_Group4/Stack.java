// Stack.java
public class Stack<T> {
    private T[] stackArray;  // Array to store items
    private int top;         // Index of top element

    @SuppressWarnings("unchecked")
    public Stack(int arraySize) {
        stackArray = (T[]) new Object[arraySize];  // Generic array
        top = -1;
    }

    // Push a new item (LIFO)
    public void push(T newItem) {
        if (top == stackArray.length - 1)
            throw new RuntimeException("Stack is full");
        stackArray[++top] = newItem;
    }

    // Pop the top item
    public T pop() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return stackArray[top--];
    }

    // Peek at top item
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return stackArray[top];
    }

    // Check if empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Display content
    public void display() {
        System.out.print("Stack: [");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i]);
            if (i < top) System.out.print(", ");
        }
        System.out.println("]");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stackArray[i]);
            if (i < top) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
