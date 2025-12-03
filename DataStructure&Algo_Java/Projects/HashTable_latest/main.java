import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== HASH TABLE TEST MENU ===");
        System.out.println("1. Unordered Array");
        System.out.println("2. Linear Probing");
        System.out.println("3. Quadratic Probing");
        System.out.println("4. Double Hashing");
        System.out.println("5. Separate Chaining");
        System.out.print("Choose a table type: ");

        int choice = sc.nextInt();
        sc.nextLine();  // flush leftover newline

        HashTable<String> table;

        switch (choice) {
            case 1:
                table = new UnorderedArray<>(20);
                break;
            case 2:
                table = new LinearProbing<>(20);
                break;
            case 3:
                table = new QuadraticProbing<>(20);
                break;
            case 4:
                table = new DoubleHashing<>(20);
                break;
            case 5:
                table = new SeparateChaining<>(20);
                break;
            default:
                System.out.println("Invalid. Exiting.");
                return;
        }

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Print");
            System.out.println("5. Exit");

            System.out.print("Choose: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.print("Key: ");
                String key = sc.nextLine();
                System.out.print("Value: ");
                String val = sc.nextLine();
                table.insert(key, val);
                System.out.println("Inserted.");

            } else if (op == 2) {
                System.out.print("Search key: ");
                String key = sc.nextLine();
                String result = table.search(key);
                if (result != null)
                    System.out.println("Found: " + result);
                else
                    System.out.println("Not found.");

            } else if (op == 3) {
                System.out.print("Delete key: ");
                String key = sc.nextLine();
                if (table.delete(key))
                    System.out.println("Deleted.");
                else
                    System.out.println("Not found.");
            }

            else if (op == 4) {
                table.print();
            }

            else if (op == 5) {
                System.out.println("Exiting...");
                break;
            }
        }
    }
}
