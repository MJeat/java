import java.lang.reflect.Array;

/**
 * A dynamic ordered array that keeps elements sorted.
 * Requires T to implement Comparable<T>.
 */
public class OrderedArray<T extends Comparable<T>> {
    private T[] arr;
    private int count;
    private Class<T> clazz;  // Store class for creating arrays via reflection

    @SuppressWarnings("unchecked")
    public OrderedArray(Class<T> clazz, int size) {
        if (size <= 0) throw new IllegalArgumentException("Size must be positive");
        this.clazz = clazz;
        this.arr = (T[]) Array.newInstance(clazz, size);  // Safe array creation
        this.count = 0;
    }

    /**
     * Inserts element in sorted order (ascending).
     * Time Complexity: O(n) due to shifting
     * @param x element to insert
     */
    public void insert(T x) {
        if (x == null) return;
        if (count == arr.length) {
            resize(arr.length * 2);
        }

        // Shift elements greater than x to the right
        int i = count - 1;
        while (i >= 0 && arr[i] != null && arr[i].compareTo(x) > 0) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = x;
        count++;
    }

    /**
     * Deletes first occurrence of x by shifting left.
     * Time Complexity: O(n)
     * @param x element to delete
     * @return true if deleted, false otherwise
     */
    public boolean delete(T x) {
        int index = find(x);
        if (index == -1) return false;

        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[count - 1] = null;
        count--;
        return true;
    }

    /**
     * Binary search for x.
     * Time Complexity: O(log n)
     * @param x element to find
     * @return index of x, or -1 if not found
     */
    public int find(T x) {
        int low = 0;
        int high = count - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(x);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Get element at index.
     * Time Complexity: O(1)
     * @param index index to retrieve
     * @return element at index
     * @throws IndexOutOfBoundsException if invalid
     */
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + count);
        }
        return arr[index];
    }

    /**
     * Return current size.
     * Time Complexity: O(1)
     * @return count
     */
    public int size() {
        return count;
    }

    /**
     * Resize internal array using reflection to preserve type safety.
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
     * Returns string representation of the array.
     * @return formatted string
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