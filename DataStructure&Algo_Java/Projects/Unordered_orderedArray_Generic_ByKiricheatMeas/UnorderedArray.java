import java.lang.reflect.Array;

/**
 * A dynamic unordered array that stores elements in insertion order.
 * Supports generic types safely using reflection.
 */
public class UnorderedArray<T> {
    private T[] arr;           // Generic array to hold elements
    private int count;         // Number of elements currently stored
    private Class<T> clazz;    // Store class for safe array creation

    /**
     * Constructs an UnorderedArray with the given initial capacity.
     * @param clazz the runtime class of type T
     * @param size the initial capacity
     */
    @SuppressWarnings("unchecked")
    public UnorderedArray(Class<T> clazz, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.clazz = clazz;
        this.arr = (T[]) Array.newInstance(clazz, size); // ✅ Safe array creation
        this.count = 0;
    }

    /**
     * Inserts a new element at the end.
     * Time Complexity: O(1) amortized
     * @param x element to insert
     */
    public void insert(T x) {
        if (x == null) return; // Skip null inserts
        if (count == arr.length) {
            resize(arr.length * 2);
        }
        arr[count++] = x;
    }

    /**
     * Deletes the first occurrence of the given value.
     * Replaces it with the last element for efficiency.
     * Time Complexity: O(n)
     * @param x element to delete
     * @return true if removed, false otherwise
     */
    public boolean delete(T x) {
        for (int i = 0; i < count; i++) {
            if ((arr[i] == null && x == null) || 
                (arr[i] != null && arr[i].equals(x))) {
                arr[i] = arr[count - 1];  // Replace with last
                arr[count - 1] = null;    // Clear old spot
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for the given value.
     * Time Complexity: O(n)
     * @param x element to find
     * @return index of x, or -1 if not found
     */
    public int find(T x) {
        for (int i = 0; i < count; i++) {
            if ((arr[i] == null && x == null) ||
                (arr[i] != null && arr[i].equals(x))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Gets the element at the specified index.
     * Time Complexity: O(1)
     * @param index index to retrieve
     * @return element at index
     * @throws IndexOutOfBoundsException if invalid index
     */
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + count);
        }
        return arr[index];
    }

    /**
     * Returns current number of elements.
     * Time Complexity: O(1)
     * @return count
     */
    public int size() {
        return count;
    }

    /**
     * Resizes internal array to new size.
     * Elements beyond new size are discarded.
     * Time Complexity: O(n)
     * @param newSize new size
     */
    public void resize(int newSize) {
        if (newSize < 0) {
            throw new IllegalArgumentException("New size cannot be negative");
        }
        @SuppressWarnings("unchecked")
        T[] newArr = (T[]) Array.newInstance(clazz, newSize);
        int elementsToCopy = Math.min(count, newSize);
        System.arraycopy(arr, 0, newArr, 0, elementsToCopy);
        arr = newArr;
        if (count > newSize) {
            count = newSize;
        }
    }

    /**
     * Returns a string representation of the array.
     * @return string of elements
     */
    @Override
    public String toString() {
        if (count == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < count; i++) {
            sb.append(arr[i]);
            if (i < count - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}