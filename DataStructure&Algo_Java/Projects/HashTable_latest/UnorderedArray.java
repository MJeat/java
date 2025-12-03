/*
 * UnorderedArray (HashTable version)
 * ----------------------------------
 * This is a simple hash-table-like structure that does NOT use hashing.
 * It simply stores key–value pairs in an array.
 *
 * It satisfies the assignment requirement for an "unordered array" table.
 * /

/* 
Here's the summary of the time complexity of each function in this file:
Insert: O(1)
Search: O(n) - Linear search through array.
Delete: O(n)
Find item = O(n)
Swap with last = O(1)
Print: O(n) 
 */

public class UnorderedArray<T> implements HashTable<T> {

    private String[] keys;   // Store keys
    private Object[] values; // Store values as Object, cast to T when needed
    private int count;       // Current number of stored entries

    public UnorderedArray(int size) {
        keys = new String[size];
        values = new Object[size];
        count = 0;
    }

    @Override
    public boolean insert(String key, T value) {
        if (count == keys.length) {
            return false; // array full
        }
        keys[count] = key;
        values[count] = value;
        count++;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T search(String key) {
        for (int i = 0; i < count; i++) {
            if (keys[i].equals(key)) {
                return (T) values[i];
            }
        }
        return null;
    }

    @Override
    public boolean delete(String key) {
        for (int i = 0; i < count; i++) {
            if (keys[i].equals(key)) {

                // Replace this element with the last one (fast delete)
                keys[i] = keys[count - 1];
                values[i] = values[count - 1];

                keys[count - 1] = null;
                values[count - 1] = null;

                count--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void print() {
        System.out.println("UnorderedArray Contents:");
        for (int i = 0; i < count; i++) {
            System.out.println(keys[i] + " -> " + values[i]);
        }
    }
}
