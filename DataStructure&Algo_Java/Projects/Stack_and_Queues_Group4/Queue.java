// Queue.java
public class Queue<T> {
    private T[] queueArray;
    private int front, rear, size;

    @SuppressWarnings("unchecked")
    public Queue(int arraySize) {
        queueArray = (T[]) new Object[arraySize];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert item at rear (FIFO)
    public void insert(T newItem) {
        if (isFull())
            throw new RuntimeException("Queue is full");
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = newItem;
        size++;
    }

    // Remove item from front
    public T remove() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        T temp = queueArray[front];
        front = (front + 1) % queueArray.length;
        size--;
        return temp;
    }

    public T peekFront() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queueArray[front];
    }

    public T peekRear() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queueArray[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queueArray.length;
    }

    public void display() {
        System.out.print("Queue: [");
        for (int i = 0; i < size; i++) {
            System.out.print(queueArray[(front + i) % queueArray.length]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(queueArray[(front + i) % queueArray.length]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}