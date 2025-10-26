/**
 * Node class for doubly linked list
 */
class DoublyLink<T> {
    T data;           // Data stored in the node
    DoublyLink<T> next;      // Reference to next node
    DoublyLink<T> previous;  // Reference to previous node
    
    // Constructor
    public DoublyLink(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}