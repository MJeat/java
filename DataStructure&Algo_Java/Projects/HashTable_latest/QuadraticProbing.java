/*
 * Quadratic Probing
 * -----------------
 * Uses: (hash + i*i) % size
 */

/* 
Here's the summary of the time complexity of each function in this file:
Insert: O(1) average, O(n) worst - Quadratic movement reduces collision but can still loop.
Search: O(1) average, O(n) worst
Delete: O(n) worst - Same search process as insert
Print: O(n)
 */

public class QuadraticProbing<T> implements HashTable<T> {

    private HashEntry<T>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public QuadraticProbing(int size) {
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
            int pos = (index + i * i) % size;

            if (table[pos] == null || table[pos].deleted) {
                table[pos] = new HashEntry<>(key, value);
                return true;
            }
        }
        return false;
    }

    @Override
    public T search(String key) {
        int index = hash(key);

        for (int i = 0; i < size; i++) {
            int pos = (index + i * i) % size;

            if (table[pos] == null) return null;
            if (!table[pos].deleted && table[pos].key.equals(key))
                return table[pos].value;
        }
        return null;
    }

    @Override
    public boolean delete(String key) {
        int index = hash(key);

        for (int i = 0; i < size; i++) {
            int pos = (index + i * i) % size;

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
        System.out.println("Quadratic Probing Table:");
        for (int i = 0; i < size; i++) {
            if (table[i] == null || table[i].deleted)
                System.out.println(i + ": empty");
            else
                System.out.println(i + ": " + table[i].key + " -> " + table[i].value);
        }
    }
}

