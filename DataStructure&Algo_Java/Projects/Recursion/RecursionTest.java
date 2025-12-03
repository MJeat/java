public class RecursionTest {
    public static void main(String[] args) {
        RecursiveSolution rs = new RecursiveSolution();

        System.out.println("=== Recursive Solutions ===");

        // (a) tri
        System.out.println("tri(-5): " + rs.tri(5));

        // (b) factorial
        System.out.println("fact(5): " + rs.fact(5));

        // (c) fib
        System.out.println("fib(6): " + rs.fib(6));

        // (d) reverseStr
        System.out.println("reverseStr('hello'): " + rs.reverseStr("hello"));

        // (e) Check char
        System.out.println("hasChar('hello', 'e'): " + rs.hasChar("hello", 'e'));
        System.out.println("hasChar('hello', 'z'): " + rs.hasChar("hello", 'z'));

        // (f) greatest common divisor 
        System.out.println("gcd(24, 18): " + rs.gcd(24, 18));

        // (g) countUniquePaths
        System.out.println("countUniquePaths(3, 3): " + rs.countUniquePaths(3, 3));
    }
}
