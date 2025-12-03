public class RecursiveSolution{
    // (a) Sum of all non-negative integers up to n
    public int tri(int n) {
        if (n <= 0)
            return 0;
        return n + tri(n - 1);
    }

    // (b) Factorial of n
    public int fact(int n) {
        if (n <= 1)
            return 1;
        return n * fact(n - 1);
    }

    // (c) Fibonacci number
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    // (d) Reverse a string
    public String reverseStr(String str) {
        if (str == null || str.length() <= 1)
            return str;
        return reverseStr(str.substring(1)) + str.charAt(0);
    }

    // (e) Check if string has a character
    public boolean hasChar(String str, char c) {
        if (str == null || str.length() == 0)
            return false;
        if (str.charAt(0) == c)
            return true;
        return hasChar(str.substring(1), c);
    }

    // (f) Greatest Common Divisor (GCD)
    public int gcd(int x1, int x2) {
        if (x2 == 0)
            return x1;
        return gcd(x2, x1 % x2);
    }

    // (g) Count unique paths in grid (n*m)
    public int countUniquePaths(int n, int m) {
        if (n == 1 || m == 1)   // If only one row or one column, only one path
            return 1;
        // Move down or right
        return countUniquePaths(n - 1, m) + countUniquePaths(n, m - 1);
    }
}
