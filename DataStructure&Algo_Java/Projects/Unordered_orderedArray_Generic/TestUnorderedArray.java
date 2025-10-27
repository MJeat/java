class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) return false;
        Person p = (Person) obj;
        return name.equals(p.name) && age == p.age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}

public class TestUnorderedArray {
    public static void main(String[] args) {
        System.out.println("Testing UnorderedArray with Multiple Data Types\n");

        // 1. Test with Strings
        System.out.println("Testing with Strings:");
        UnorderedArray<String> names = new UnorderedArray<>(String.class, 3);
        names.insert("Alice");
        names.insert("Charlie");
        names.insert("Bob");
        printArray(names);

        names.delete("Bob");
        System.out.println("After deleting Bob:");
        printArray(names);
        System.out.println();

        // 2. Test with Integers
        System.out.println("Testing with Integers:");
        UnorderedArray<Integer> numbers = new UnorderedArray<>(Integer.class, 4);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        printArray(numbers);

        System.out.println("Find 20: " + numbers.find(20));
        System.out.println();

        // 3. Test with Doubles
        System.out.println("Testing with Doubles:");
        UnorderedArray<Double> prices = new UnorderedArray<>(Double.class, 3);
        prices.insert(9.99);
        prices.insert(15.50);
        prices.insert(3.75);
        printArray(prices);
        System.out.println();

        // 4. Test with Custom Objects (Person)
        System.out.println("Testing with Custom Objects (Person):");
        UnorderedArray<Person> people = new UnorderedArray<>(Person.class, 3);
        Person alice = new Person("Alice", 30);
        Person bob = new Person("Bob", 25);
        Person charlie = new Person("Charlie", 35);

        people.insert(alice);
        people.insert(bob);
        people.insert(charlie);
        printArray(people);

        people.delete(bob);
        System.out.println("After deleting Bob:");
        printArray(people);
        System.out.println();

        //  5. Resize Test
        System.out.println("Testing Resize:");
        numbers.resize(2);
        System.out.println("Resized numbers to size 2:");
        printArray(numbers);
        numbers.insert(40);
        System.out.println("Inserted 40 after resize:");
        printArray(numbers);
    }

    // Helper method: Print any UnorderedArray
    static <T> void printArray(UnorderedArray<T> arr) {
        System.out.println("Array: " + arr);
        System.out.println("Size: " + arr.size());
    }
}