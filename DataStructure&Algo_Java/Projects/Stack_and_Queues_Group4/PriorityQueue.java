public class PriorityQueue<T> {
    private static class Node<T> {
        T data;
        int priority;
        
        Node(T data, int priority) {
            this.data = data;
            this.priority = priority;
        }
        
        @Override
        public String toString() {
            return data + "(p:" + priority + ")";
        }
    }
    
    private Node<T>[] heap;
    private int size;
    private int capacity;

    // (a) Constructor
    @SuppressWarnings("unchecked")
    public PriorityQueue(int arraySize) {
        this.capacity = arraySize;
        this.heap = new Node[capacity];
        this.size = 0;
    }

    // (b) Insert item with priority (higher number = higher priority)
    public void insert(T newItem, int priorityValue) {
        if (isFull()) {
            throw new RuntimeException("PriorityQueue is full");
        }
        
        // Create new node and add to end
        Node<T> newNode = new Node<>(newItem, priorityValue);
        heap[size] = newNode;
        size++;
        
        // Bubble up to maintain heap property
        bubbleUp(size - 1);
    }

    // (c) Remove and return highest priority item
    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("PriorityQueue is empty");
        }
        
        T highestPriorityItem = heap[0].data;
        
        // Move last element to root and bubble down
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        
        if (size > 0) {
            bubbleDown(0);
        }
        
        return highestPriorityItem;
    }

    // (d) Peek at highest priority item (front)
    public T peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("PriorityQueue is empty");
        }
        return heap[0].data;
    }

    // (e) Peek at lowest priority item (rear)
    public T peekRear() {
        if (isEmpty()) {
            throw new RuntimeException("PriorityQueue is empty");
        }
        
        // Find the lowest priority leaf node
        int lowestPriorityIndex = findLowestPriorityIndex();
        return heap[lowestPriorityIndex].data;
    }

    // (f) String representation
    public String toString() {
        if (isEmpty()) {
            return "PriorityQueue: []";
        }
        
        StringBuilder sb = new StringBuilder("PriorityQueue: [");
        for (int i = 0; i < size; i++) {
            sb.append(heap[i].toString());
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // (g) Display priority queue contents
    public void display() {
        System.out.println(this.toString());
    }

    // Helper methods
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    // Private helper methods for heap operations
    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            
            // If current node has higher priority than parent, swap
            if (heap[index].priority > heap[parentIndex].priority) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void bubbleDown(int index) {
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;
            
            // Compare with left child
            if (leftChild < size && heap[leftChild].priority > heap[largest].priority) {
                largest = leftChild;
            }
            
            // Compare with right child
            if (rightChild < size && heap[rightChild].priority > heap[largest].priority) {
                largest = rightChild;
            }
            
            // If largest is not current, swap and continue
            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private int findLowestPriorityIndex() {
        // Start from the first leaf node
        int firstLeaf = size / 2;
        int lowestIndex = firstLeaf;
        int lowestPriority = heap[firstLeaf].priority;
        
        for (int i = firstLeaf + 1; i < size; i++) {
            if (heap[i].priority < lowestPriority) {
                lowestPriority = heap[i].priority;
                lowestIndex = i;
            }
        }
        
        return lowestIndex;
    }

    private void swap(int i, int j) {
        Node<T> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}