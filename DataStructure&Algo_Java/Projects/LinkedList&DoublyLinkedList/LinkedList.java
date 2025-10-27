/**
 * Generic Doubly-Ended Singly Linked List Implementation
 * Supports O(1) insertion at both head and tail.
 */
public class LinkedList<T> {
    private Link<T> head; // Points to first node
    private Link<T> tail; // Points to last node

    // Constructor – O(1)
    public LinkedList() {
        head = null;
        tail = null;
    }

    // Insert a new element at the beginning – O(1)
    public void insertFirst(T newItem) {
        Link<T> newLink = new Link<>(newItem);
        if (isEmpty()) {
            head = newLink;
            tail = newLink;
        } else {
            newLink.next = head;
            head = newLink;
        }
    }

    // Insert a new element at the end – O(1)
    public void insertLast(T newItem) {
        Link<T> newLink = new Link<>(newItem);
        if (isEmpty()) {
            head = newLink;
            tail = newLink;
        } else {
            tail.next = newLink;
            tail = newLink;
        }
    }

    // Insert at a specific index – O(n)
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
            if (newLink.next == null) tail = newLink; // update tail if added at end
        }
    }

    // Delete first element – O(1)
    public boolean deleteFirst() {
        if (isEmpty()) return false;

        head = head.next;
        if (head == null) tail = null; // list becomes empty
        return true;
    }

    // Delete last element – O(n) because we must find the second-last node
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (head == tail) { // only one element
            head = null;
            tail = null;
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

    // Delete element at specific index – O(n)
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

        if (current.next == tail) tail = current; // update tail if last element removed
        current.next = current.next.next;
        return true;
    }

    // Delete first occurrence of a specific key – O(n)
    public boolean deleteKey(T key) {
        if (isEmpty()) return false;

        if (head.data.equals(key)) {
            return deleteFirst();
        }

        Link<T> current = head;
        while (current.next != null && !current.next.data.equals(key)) {
            current = current.next;
        }

        if (current.next == null) return false;

        if (current.next == tail) tail = current; // update tail if deleted last node
        current.next = current.next.next;
        return true;
    }

    // Find index of the first occurrence of a key – O(n)
    public int find(T key) {
        Link<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(key)) return index;
            current = current.next;
            index++;
        }
        return -1; // not found
    }

    // Check if the list is empty – O(1)
    public boolean isEmpty() {
        return head == null;
    }

    // Convert list to a readable string – O(n)
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Link<T> current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Display list contents – O(n)
    public void display() {
        System.out.println(toString());
    }
}
