// Example custom class
class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age); // Sort by age
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

public class TestOrderedArray {
    public static void main(String[] args) {
        System.out.println("Testing OrderedArray with Multiple Data Types\n");

        //  1. Test with Integers
        System.out.println("Testing with Integers:");
        OrderedArray<Integer> nums = new OrderedArray<>(Integer.class, 5);
        nums.insert(30);
        nums.insert(10);
        nums.insert(20);
        printArray(nums);

        nums.delete(20);
        System.out.println("After deleting 20:");
        printArray(nums);
        System.out.println();

        // 2. Test with Strings
        System.out.println("Testing with Strings:");
        OrderedArray<String> words = new OrderedArray<>(String.class, 4);
        words.insert("banana");
        words.insert("apple");
        words.insert("cherry");
        printArray(words); // Here, banana comes before apple, but once it prints, apple comes first

        words.delete("apple");
        System.out.println("After deleting 'apple':");
        printArray(words);
        System.out.println();

        // 3. Test with Doubles
        System.out.println("Testing with Doubles:");
        OrderedArray<Double> grades = new OrderedArray<>(Double.class, 3);
        grades.insert(95.5);
        grades.insert(87.2);
        grades.insert(90.0);
        printArray(grades);
        System.out.println();

        //  4. Test with Custom Objects (Person)
        System.out.println("Testing with Custom Objects (Person):");
        OrderedArray<Person> people = new OrderedArray<>(Person.class, 3);
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

        // 5. Resize Test
        System.out.println("Testing Resize:");
        nums.resize(2);
        System.out.println("Resized numbers to size 2:");
        printArray(nums);
        nums.insert(40);
        System.out.println("Inserted 40 after resize:");
        printArray(nums);
    }

    // This is the helper method: Print any OrderedArray
    static <T extends Comparable<T>> void printArray(OrderedArray<T> arr) {
        System.out.println("Sorted Array: " + arr);
        System.out.println("Size: " + arr.size());
    }
}