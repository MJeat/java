import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for DoublyLinkedList
 * Supports forward traversal.
 */
public class DoublyLinkedListIterator<T> implements Iterator<T> {
    private DoublyLink<T> current;

    // Constructor: start from first node
    public DoublyLinkedListIterator(DoublyLink<T> start) {
        this.current = start;
    }

    // Checks if next node exists
    @Override
    public boolean hasNext() {
        return current != null;
    }

    // Returns current node data and moves to next
    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException("No more elements");
        T data = current.data;
        current = current.next;
        return data;
    }
}
