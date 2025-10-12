// Queue.java
public class Queue<T> {
    private T[] queueArray;
    private int front, rear, size, maxSize;

    @SuppressWarnings("unchecked")
    public Queue(int arraySize) {
        maxSize = arraySize;
        queueArray = (T[]) new Object[maxSize];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void insert(T newItem) {
        if (size == maxSize)
            throw new RuntimeException("Queue is full");
        rear = (rear + 1) % maxSize;
        queueArray[rear] = newItem;
        size++;
    }

    public T remove() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        T item = queueArray[front];
        front = (front + 1) % maxSize;
        size--;
        return item;
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

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(queueArray[(front + i) % maxSize]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public void display() {
        System.out.println(this.toString());
    }
}
