/**
 * An implementation of an array that keeps integers in sorted order.
 * Insertion maintains order; deletion shifts elements.
 * Supports binary search for faster lookups.
 */

public class OrderedArray {
    private Integer[] arr;   // Storage array (null indicates unused)
    private int count;       // Number of elements currently stored
    public OrderedArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        arr = new Integer[size];
        count = 0;
    }

    /**
     * Inserts a new element in sorted order.
     * If the array is full, it resizes to double the current size.
     * Time Complexity: O(n) due to shifting elements
     * @param x the integer to insert
     */
    public void insert(int x) {
        if (count == arr.length) {
            resize(arr.length * 2);
        }

        // Find correct position to insert (maintain sorted order)
        int i = count - 1;
        while (i >= 0 && arr[i] != null && arr[i] > x) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = x;
        count++;
    }

    /**
     * Deletes the first occurrence of the given value by shifting left.
     * Time Complexity: O(n) — O(n) search + O(n) shift
     * @param x the integer to delete
     * @return true if the element was found and removed, false otherwise
     */
    public boolean delete(int x) {
        int index = find(x);
        if (index == -1) {
            return false;
        }

        // Shift all elements left from index
        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[count - 1] = null;
        count--;
        return true;
    }

    /**
     * Searches for the given value using binary search.
     * Time Complexity: O(log n)
     * @param x the integer to find
     * @return index of x if found, -1 otherwise
     */
    public int find(int x) {
        int low = 0;
        int high = count - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Retrieves the element at the specified index.
     * Time Complexity: O(1)
     * @param index the index to retrieve
     * @return the integer at the given index
     * @throws IndexOutOfBoundsException if index < 0 or >= count
     */
    public int get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    /**
     * Returns the number of elements currently in the array.
     * Time Complexity: O(1)
     * @return current size
     */
    public int size() {
        return count;
    }

    /**
     * Resizes the internal array to the new size.
     * If newSize is smaller, excess elements are discarded.
     * If newSize is larger, new slots are left as null.
     * Time Complexity: O(n), where n is min(count, newSize)
     * @param newSize the new size of the array
     */
    public void resize(int newSize) {
        if (newSize < 0) {
            throw new IllegalArgumentException("New size cannot be negative");
        }
        Integer[] newArr = new Integer[newSize];
        int elementsToCopy = Math.min(count, newSize);
        System.arraycopy(arr, 0, newArr, 0, elementsToCopy);
        arr = newArr;
        if (count > newSize) {
            count = newSize;
        }
    }
}