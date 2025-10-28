import java.util.Iterator;
import java.util.NoSuchElementException;

// Generic Iterator for Singly Linked List
public class LinkedListIterator<T> implements Iterator<T> {
    private Link<T> current; // pointer to current node

    public LinkedListIterator(Link<T> start) {
        this.current = start;
    }

    @Override
    public boolean hasNext() { // Checks if more elements exist
        return current != null;
    }

    @Override
    public T next() { // Returns next element and moves cursor
        if (!hasNext()) throw new NoSuchElementException("No more elements");
        T data = current.data;
        current = current.next;
        return data;
    }
}
