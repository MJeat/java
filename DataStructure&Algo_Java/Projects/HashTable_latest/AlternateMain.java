/*
 * Main.java
 * ----------
 * This file tests ALL hash table implementations:
 * 1. UnorderedArray
 * 2. Linear Probing
 * 3. Quadratic Probing
 * 4. Double Hashing
 * 5. Separate Chaining
 *
 * It inserts sample values, searches values, deletes values,
 * and prints the final state of each table.
 */

public class AlternateMain {

    public static void main(String[] args) {

        System.out.println("=== HASH TABLE TESTING START ===\n");

        // --------------------------------------------------
        // 1. UNORDERED ARRAY
        // --------------------------------------------------
        HashTable<String> ua = new UnorderedArray<>(20);
        System.out.println(">> Testing UnorderedArray...");
        runTests(ua);


        // --------------------------------------------------
        // 2. LINEAR PROBING
        // --------------------------------------------------
        HashTable<String> lp = new LinearProbing<>(20);
        System.out.println("\n>> Testing LinearProbing...");
        runTests(lp);


        // --------------------------------------------------
        // 3. QUADRATIC PROBING
        // --------------------------------------------------
        HashTable<String> qp = new QuadraticProbing<>(20);
        System.out.println("\n>> Testing QuadraticProbing...");
        runTests(qp);


        // --------------------------------------------------
        // 4. DOUBLE HASHING
        // --------------------------------------------------
        HashTable<String> dh = new DoubleHashing<>(20);
        System.out.println("\n>> Testing DoubleHashing...");
        runTests(dh);


        // --------------------------------------------------
        // 5. SEPARATE CHAINING
        // --------------------------------------------------
        HashTable<String> sc = new SeparateChaining<>(20);
        System.out.println("\n>> Testing SeperateChaining...");
        runTests(sc);

        System.out.println("\n=== HASH TABLE TESTING COMPLETE ===");
    }


    // ----------------------------------------------------------
    // UNIVERSAL TEST FUNCTION FOR ALL HASH TABLE TYPES
    // ----------------------------------------------------------
    private static void runTests(HashTable<String> table) {

        // INSERT
        System.out.println("Inserting values...");
        table.insert("apple", "A sweet fruit");
        table.insert("banana", "A yellow fruit");
        table.insert("carrot", "A vegetable");
        table.insert("dog", "An animal");
        table.insert("egg", "A protein food");

        // SEARCH
        System.out.println("Searching for 'banana': " + table.search("banana"));
        System.out.println("Searching for 'carrot': " + table.search("carrot"));
        System.out.println("Searching for 'missing': " + table.search("missing"));

        // DELETE
        System.out.println("Deleting 'dog': " + table.delete("dog"));
        System.out.println("Deleting 'missing': " + table.delete("missing"));

        // PRINT TABLE
        System.out.println("Final table contents:");
        table.print();

        System.out.println("----------------------------------");
    }
}
