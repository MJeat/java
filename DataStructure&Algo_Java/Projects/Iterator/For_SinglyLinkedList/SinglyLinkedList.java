/**
 * Generic Doubly-Ended Singly Linked List Implementation
 * Supports O(1) insertion at both head and tail.
 * Now implements Iterable<T> using LinkedListIterator.
 */
import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
    private Link<T> head; // Points to first node
    private Link<T> tail; // Points to last node

    // Constructor – O(1)
    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    // Insert at beginning – O(1)
    public void insertFirst(T newItem) {
        Link<T> newLink = new Link<>(newItem);
        if (isEmpty()) {
            head = tail = newLink;
        } else {
            newLink.next = head;
            head = newLink;
        }
    }

    // Insert at end – O(1)
    public void insertLast(T newItem) {
        Link<T> newLink = new Link<>(newItem);
        if (isEmpty()) {
            head = tail = newLink;
        } else {
            tail.next = newLink;
            tail = newLink;
        }
    }

    // Insert at specific index – O(n)
    public void insertAt(T newItem, int index) {
        if (index < 0) {
            System.out.println("Index cannot be negative.");
            return;
        }
        if (index == 0) {
            insertFirst(newItem);
            return;
        }

        Link<T> newLink = new Link<>(newItem);
        Link<T> current = head;
        int count = 0;

        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Index out of range.");
        } else {
            newLink.next = current.next;
            current.next = newLink;
            if (newLink.next == null) tail = newLink; // update tail if last
        }
    }

    // Delete first element – O(1)
    public boolean deleteFirst() {
        if (isEmpty()) return false;
        head = head.next;
        if (head == null) tail = null;
        return true;
    }

    // Delete last element – O(n)
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = tail = null;
            return true;
        }
        Link<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
        return true;
    }

    // Delete at index – O(n)
    public boolean deleteAt(int index) {
        if (index < 0 || isEmpty()) return false;
        if (index == 0) return deleteFirst();

        Link<T> current = head;
        int count = 0;
        while (current.next != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current.next == null) return false;
        if (current.next == tail) tail = current;
        current.next = current.next.next;
        return true;
    }

    // Delete by key – O(n)
    public boolean deleteKey(T key) {
        if (isEmpty()) return false;
        if (head.data.equals(key)) return deleteFirst();

        Link<T> current = head;
        while (current.next != null && !current.next.data.equals(key)) {
            current = current.next;
        }
        if (current.next == null) return false;
        if (current.next == tail) tail = current;
        current.next = current.next.next;
        return true;
    }

    // Find index of key – O(n)
    public int find(T key) {
        Link<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(key)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    // Check if empty – O(1)
    public boolean isEmpty() {
        return head == null;
    }

    // Display all elements using iterator – O(n)
    public void display() {
        System.out.print("[");
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
            if (it.hasNext()) System.out.print(" -> ");
        }
        System.out.println("]");
    }

    // Return iterator
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head);
    }
}
