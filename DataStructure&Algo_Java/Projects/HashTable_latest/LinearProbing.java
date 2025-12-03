/*
 * LinearProbing Hash Table
 * ------------------------
 * Uses: index = (hash + i) % size
 * Simple collision-resolution method.
 */

/* 
Here's the summary of the time complexity of each function in this file:
Insert: O(1) average, O(n) worst - Because probing checks consecutive spots.
Search: O(1) average, O(n) worst - Worst when many collisions → cluster.
Delete: O(n) worst - Requires searching until empty slot.
Print: O(n)
 */

public class LinearProbing<T> implements HashTable<T> {

    private HashEntry<T>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public LinearProbing(int size) {
        this.size = size;
        table = new HashEntry[size];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    @Override
    public boolean insert(String key, T value) {
        int index = hash(key);

        for (int i = 0; i < size; i++) {
            int pos = (index + i) % size;

            if (table[pos] == null || table[pos].deleted) {
                table[pos] = new HashEntry<>(key, value);
                return true;
            }
        }
        return false; // full
    }

    @Override
    public T search(String key) {
        int index = hash(key);

        for (int i = 0; i < size; i++) {
            int pos = (index + i) % size;

            if (table[pos] == null) return null; // not found
            if (!table[pos].deleted && table[pos].key.equals(key))
                return table[pos].value;
        }
        return null;
    }

    @Override
    public boolean delete(String key) {
        int index = hash(key);

        for (int i = 0; i < size; i++) {
            int pos = (index + i) % size;

            if (table[pos] == null) return false;

            if (!table[pos].deleted && table[pos].key.equals(key)) {
                table[pos].deleted = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public void print() {
        System.out.println("Linear Probing Table:");
        for (int i = 0; i < size; i++) {
            if (table[i] == null || table[i].deleted)
                System.out.println(i + ": empty");
            else
                System.out.println(i + ": " + table[i].key + " -> " + table[i].value);
        }
    }
}
