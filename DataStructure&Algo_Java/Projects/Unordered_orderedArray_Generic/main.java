public class main {
    public static void main(String[] args) {
        // === TEST UNORDERED ARRAY WITH STRINGS ===
        System.out.println("=== Testing UnorderedArray<String> ===");
        UnorderedArray<String> names = new UnorderedArray<>(3);
        names.insert("Alice");
        names.insert("Bob");
        names.insert("2");

        System.out.println("Size: " + names.size());
        System.out.println("Find Bob: " + names.find("Bob"));
        System.out.print("All: ");
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + " ");
        }
        System.out.println();

        names.delete("Bob");
        System.out.println("After deleting Bob, size: " + names.size());

        // === TEST ORDERED ARRAY WITH INTEGERS ===
        System.out.println("\n=== Testing OrderedArray<Integer> ===");
        OrderedArray<Integer> nums = new OrderedArray<>(Integer.class, 5);

        nums.insert(30);
        nums.insert(10);
        nums.insert(20);

        System.out.print("Sorted: ");
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();

        System.out.println("Find 20: " + nums.find(20));
        nums.delete(20);
        System.out.println("After delete, size: " + nums.size());
    }
}