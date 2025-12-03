/*
 * HashEntry
 * ---------
 * A simple key–value structure stored in hash tables.
 * 'deleted' flag is used for probing tables to mark removed positions.
 */

/* 
Here's the summary of the time complexity of each function in this file:
Insert: O(1) average - Just add node to a linked list.
Search: O(1) average, O(n) worst - when everything in one bucket.
Delete:
   average O(1)
   worst O(n) (delete in linked list)
Print: O(n)
 */

public class HashEntry<T> {
    String key;
    T value;
    boolean deleted;

    public HashEntry(String key, T value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }
}
