/*
 * Separate Chaining
 * -----------------
 * Each index stores a linked list (bucket).
 */

import java.util.LinkedList;

public class SeparateChaining<T> implements HashTable<T> {

    private LinkedList<HashEntry<T>>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public SeparateChaining(int size) {
        this.size = size;
        table = new LinkedList[size];

        for (int i = 0; i < size; i++)
            table[i] = new LinkedList<>();
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    @Override
    public boolean insert(String key, T value) {
        int index = hash(key);
        table[index].add(new HashEntry<>(key, value));
        return true;
    }

    @Override
    public T search(String key) {
        int index = hash(key);
        for (HashEntry<T> entry : table[index]) {
            if (entry.key.equals(key))
                return entry.value;
        }
        return null;
    }

    @Override
    public boolean delete(String key) {
        int index = hash(key);
        return table[index].removeIf(entry -> entry.key.equals(key));
    }

    @Override
    public void print() {
        System.out.println("Separate Chaining Table:");
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (HashEntry<T> entry : table[i]) {
                System.out.print(entry.key + " -> " + entry.value + "  ");
            }
            System.out.println();
        }
    }
}

