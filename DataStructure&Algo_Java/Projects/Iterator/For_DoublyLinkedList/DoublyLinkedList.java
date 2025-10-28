import java.util.Iterator;

/**
 * Generic Doubly Linked List Implementation
 * Supports insertion, deletion, and traversal in both directions.
 */
public class DoublyLinkedList<T> implements Iterable<T> {
    private DoublyLink<T> first;  // Reference to first node
    private DoublyLink<T> last;   // Reference to last node
    private int size;             // Number of elements in list

    /**
     * Constructor - O(1)
     * Creates an empty doubly linked list.
     */
    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /** Insert at beginning - O(1) */
    public void insertFirst(T newItem) {
        DoublyLink<T> newLink = new DoublyLink<>(newItem);

        if (isEmpty()) {
            first = newLink;
            last = newLink;
        } else {
            newLink.next = first;
            first.previous = newLink;
            first = newLink;
        }
        size++;
    }

    /** Insert at end - O(1) */
    public void insertLast(T newItem) {
        DoublyLink<T> newLink = new DoublyLink<>(newItem);

        if (isEmpty()) {
            first = newLink;
            last = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
            last = newLink;
        }
        size++;
    }

    /** Insert at beginning (alias for insertFirst) - O(1) */
    public void insertAt(T newItem) {
        insertFirst(newItem);
    }

    /** Delete first element - O(1) */
    public boolean deleteFirst() {
        if (isEmpty()) return false;

        if (first == last) { // only one element
            first = null;
            last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
        return true;
    }

    /** Delete last element - O(1) */
    public boolean deleteLast() {
        if (isEmpty()) return false;

        if (first == last) { // only one element
            first = null;
            last = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
        return true;
    }

    /** Delete element at specific index - O(n) */
    public boolean deleteAt(int index) {
        if (index < 0 || index >= size) return false;

        if (index == 0) return deleteFirst();
        if (index == size - 1) return deleteLast();

        DoublyLink<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;
        return true;
    }

    /** Delete first occurrence of specific key - O(n) */
    public boolean deleteKey(T key) {
        if (isEmpty()) return false;

        DoublyLink<T> current = first;
        int index = 0;

        while (current != null) {
            if (current.data.equals(key)) {
                return deleteAt(index);
            }
            current = current.next;
            index++;
        }
        return false;
    }

    /** Find index of first occurrence of key - O(n) */
    public int find(T key) {
        DoublyLink<T> current = first;
        int index = 0;

        while (current != null) {
            if (current.data.equals(key)) return index;
            current = current.next;
            index++;
        }
        return -1; // not found
    }

    /** Check if list is empty - O(1) */
    public boolean isEmpty() {
        return first == null;
    }

    /** Get number of elements - O(1) */
    public int size() {
        return size;
    }

    /** String representation - O(n) */
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        DoublyLink<T> current = first;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /** Display list from first to last - O(n) */
    public void displayForward() {
        System.out.println("Forward: " + toString());
    }

    /** Display list from last to first - O(n) */
    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("Backward: []");
            return;
        }

        StringBuilder sb = new StringBuilder("[");
        DoublyLink<T> current = last;

        while (current != null) {
            sb.append(current.data);
            if (current.previous != null) sb.append(", ");
            current = current.previous;
        }
        sb.append("]");
        System.out.println("Backward: " + sb.toString());
    }

    /** Provide forward iterator for for-each loop */
    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator<>(first);
    }

    /** Provide reverse iterator */
    public Iterator<T> reverseIterator() {
        return new Iterator<T>() {
            private DoublyLink<T> current = last;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.previous;
                return data;
            }
        };
    }
}
