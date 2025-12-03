/*
 * HashTable Interface
 * --------------------
 * This interface defines the required operations for ANY hash table implementation.
 * All implementations (LinearProbing, QuadraticProbing, DoubleHashing,
 * SeparateChaining, and UnorderedArray) must implement these methods.
 */

public interface HashTable<T> {

    boolean insert(String key, T value);  // Insert key-value pair
    T search(String key);                // Return the value OR null
    boolean delete(String key);          // Delete a key
    void print();                        // Print internal table for debugging
}
