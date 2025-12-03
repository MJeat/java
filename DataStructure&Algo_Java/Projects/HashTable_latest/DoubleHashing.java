/*
 * Double Hashing
 * --------------
 * Uses:
 *   hash1 = main hash
 *   hash2 = 7 - (key.hashCode() % 7)
 * Position = (hash1 + i * hash2) % size
 */
/* 
Here's the summary of the time complexity of each function in this file:
Insert: O(1) average - Collisions much less frequent.
Insert worst: O(n) - If table is full or badly aligned.
Search: O(1) average
Search worst: O(n)
Delete: O(n)
Print: O(n)
 */

public class DoubleHashing<T> implements HashTable<T> {

    private HashEntry<T>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public DoubleHashing(int size) {
        this.size = size;
        table = new HashEntry[size];
    }

    private int hash1(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    private int hash2(String key) {
        return 7 - (Math.abs(key.hashCode()) % 7);
    }

    @Override
    public boolean insert(String key, T value) {
        int h1 = hash1(key);
        int h2 = hash2(key);

        for (int i = 0; i < size; i++) {
            int pos = (h1 + i * h2) % size;

            if (table[pos] == null || table[pos].deleted) {
                table[pos] = new HashEntry<>(key, value);
                return true;
            }
        }
        return false;
    }

    @Override
    public T search(String key) {
        int h1 = hash1(key);
        int h2 = hash2(key);

        for (int i = 0; i < size; i++) {
            int pos = (h1 + i * h2) % size;

            if (table[pos] == null) return null;
            if (!table[pos].deleted && table[pos].key.equals(key))
                return table[pos].value;
        }
        return null;
    }

    @Override
    public boolean delete(String key) {
        int h1 = hash1(key);
        int h2 = hash2(key);

        for (int i = 0; i < size; i++) {
            int pos = (h1 + i * h2) % size;

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
        System.out.println("Double Hashing Table:");
        for (int i = 0; i < size; i++) {
            if (table[i] == null || table[i].deleted)
                System.out.println(i + ": empty");
            else
                System.out.println(i + ": " + table[i].key + " -> " + table[i].value);
        }
    }
}

