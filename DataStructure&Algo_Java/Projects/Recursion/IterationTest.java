public class IterationTest {
    public static void main(String[] args) {
        IterativeSolution it = new IterativeSolution();

        System.out.println("=== Iterative Solutions ===");

        // (a) tri
        System.out.println("tri(-5): " + it.tri(5));

        // (b) fact
        System.out.println("fact(5): " + it.fact(5));

        // (c) fib
        System.out.println("fib(6): " + it.fib(6));

        // (d) reverseStr
        System.out.println("reverseStr('hello'): " + it.reverseStr("hello"));

        // (e) hasChar
        System.out.println("hasChar('hello', 'e'): " + it.hasChar("hello", 'e'));
        System.out.println("hasChar('hello', 'z'): " + it.hasChar("hello", 'z'));

        // (f) gcd
        System.out.println("gcd(24, 18): " + it.gcd(24, 18));

        // (g) countUniquePaths
        System.out.println("countUniquePaths(3, 3): " + it.countUniquePaths(3, 3));
    }
}
