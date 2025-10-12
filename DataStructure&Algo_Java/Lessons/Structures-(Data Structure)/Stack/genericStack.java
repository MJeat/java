public class genericStack<T> {
    private T[] data;
    private int topIndexLocation;

    // (a) Constructor with array size
    @SuppressWarnings("unchecked")
    public genericStack(int arraySize) {
        data = (T[]) new Object[arraySize];
        topIndexLocation = -1;
    }

    // (b) Push element onto stack
    public void push(T newItem) {
        if (!isFull()) {
            data[++topIndexLocation] = newItem;
        } else {
            System.out.println("Stack is full! Cannot push " + newItem);
        }
    }

    // (c) Pop element from stack
    public T pop() {
        if (!isEmpty()) {
            T elementToBeRemoved = data[topIndexLocation];
            data[topIndexLocation] = null;
            topIndexLocation--;
            return elementToBeRemoved;
        } else {
            System.out.println("Stack is empty! Cannot pop.");
            return null;
        }
    }

    // (d) Peek at top element
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return null;
        }
        return data[topIndexLocation];
    }

    // (e) String representation
    public String toString() {
        if (isEmpty()) {
            return "Stack: []";
        }
        
        StringBuilder sb = new StringBuilder("Stack: [");
        for (int i = 0; i <= topIndexLocation; i++) {
            sb.append(data[i]);
            if (i < topIndexLocation) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // (f) Display stack contents
    public void display() {
        System.out.println(this.toString());
    }

    // Your existing helper methods (keep these)
    public boolean isEmpty() {
        return topIndexLocation == -1;
    }

    // Additional
    public boolean isFull() {
        return topIndexLocation + 1 == data.length;
    }

    // Additional
    public int size() {
        return topIndexLocation + 1;
    }
    
    // Renamed from top() to maintain both for compatibility
    // Additional
    public T top() {
        return peek();
    }
}