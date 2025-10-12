public class TestUnorderedArray {
    public static void main(String[] args) {
        // ---------- TEST UNORDERED ARRAY ----------
        System.out.println("=== Testing UnorderedArray ===");
        UnorderedArray input = new UnorderedArray(5);

        input.insert(10);
        input.insert(60);
        input.insert(40);
        input.insert(90);

        System.out.println("Size: " + input.size());          // should be 4
        System.out.println("Find 20: " + input.find(90));     // should be index 3
        System.out.println("Get index 2: " + input.get(2));   // should be 40

        // Deleting a specific element, not based on index number
        input.delete(90);
        System.out.println("After delete, size: " + input.size()); // should be 3

        // Resizing the storage of the array MANUALLY to store more elements
        input.resize(10);
        System.out.println("After resize, size: " + input.size()); // should still be 3

        // Verify order is maintained
        System.out.print("Remaining elements (unsorted): ");
        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i) + " ");
        }
        System.out.println(); // Output should be unsorted
    }

}
