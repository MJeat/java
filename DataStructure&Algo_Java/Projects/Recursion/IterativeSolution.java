public class IterativeSolution {

    // (a) Sum of all non-negative integers up to n
    public int tri(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // (b) Factorial of n
    public int fact(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // (c) Fibonacci number
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int prev1 = 0, prev2 = 1;
        int current = 0;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }

    // (d) Reverse a string
    public String reverseStr(String str) {
        if (str == null)
            return null;
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    // (e) Check if string has a character
    public boolean hasChar(String str, char c) {
        if (str == null)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                return true;
        }
        return false;
    }

    // (f) Greatest Common Divisor (GCD)
    public int gcd(int x1, int x2) {
        while (x2 != 0) {
            int temp = x2;
            x2 = x1 % x2;
            x1 = temp;
        }
        return x1;
    }

    // (g) Count unique paths in grid (n * m)
    public int countUniquePaths(int n, int m) {
        int[][] dp = new int[n][m];

        // Fill first row and first column with 1
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;
        for (int j = 0; j < m; j++)
            dp[0][j] = 1;

        // Fill rest of the grid
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n - 1][m - 1];
    }
}
