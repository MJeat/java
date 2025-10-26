public class TestOrderedArray {
    public static void main(String[] args) {
        // ---------- TEST ORDERED ARRAY ----------
        System.out.println("=== Testing OrderedArray ===");
        OrderedArray input = new OrderedArray(5);

        // Insert elements (should be inserted in sorted order)
        input.insert(10);
        input.insert(60);
        input.insert(40);
        input.insert(90);

        System.out.println("Size: " + input.size());          // should be 4
        System.out.println("Find 10: " + input.find(10));     // should be index 0
        System.out.println("Find 40: " + input.find(40));     // should be index 1
        System.out.println("Find 90: " + input.find(90));     // should be index 3
        System.out.println("Get index 2: " + input.get(2));   // should be 60

        // Try to find a non-existent element
        System.out.println("Find 20: " + input.find(20));     // should be -1

        // Delete an element
        boolean deleted = input.delete(40);
        System.out.println("Delete 40 successful: " + deleted); // should be true
        System.out.println("After delete, size: " + input.size()); // should be 3
        System.out.println("Find 40 after delete: " + input.find(40)); // should be -1

        // Verify order is maintained
        System.out.print("Remaining elements: ");
        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i) + " ");
        }
        System.out.println(); // Output should be: 10 60 90

        // Resizing the array manually to store more elements
        input.resize(10);
        System.out.println("After resize to 10, size: " + input.size()); // should still be 3

        // Insert more elements after resize
        input.insert(25);
        input.insert(75);
        System.out.println("Size after more inserts: " + input.size()); // should be 5

        System.out.print("Final sorted array: ");
        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i) + " ");
        }
        System.out.println(); // Expected: 10 25 60 75 90

        // Test edge case: delete last element
        input.delete(90);
        System.out.println("After deleting 90, size: " + input.size()); // should be 4

        // Test get() with invalid index
        try {
            System.out.println("Get index -1: " + input.get(-1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught expected exception: get(-1) -> Index out of bounds");
        }

        try {
            System.out.println("Get index 100: " + input.get(100));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught expected exception: get(100) -> Index out of bounds");
        }

        System.out.println("All OrderedArray tests completed.");
    }
}