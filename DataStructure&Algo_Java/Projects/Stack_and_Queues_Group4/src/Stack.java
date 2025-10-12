// Stack.java
public class Stack<T> {
    private T[] stackArray;
    private int top;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public Stack(int arraySize) {
        maxSize = arraySize;
        stackArray = (T[]) new Object[maxSize];
        top = -1;
    }

    // Push item to top
    public void push(T newItem) {
        if (top == maxSize - 1)
            throw new RuntimeException("Stack is full");
        stackArray[++top] = newItem;
    }

    // Pop item from top
    public T pop() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return stackArray[top--];
    }

    // Peek top item
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return stackArray[top];
    }

    // Check if empty
    public boolean isEmpty() {
        return top == -1;
    }

    // String representation
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(stackArray[i]);
            if (i < top) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Display stack
    public void display() {
        System.out.println(this.toString());
    }
}
