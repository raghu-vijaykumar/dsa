package dsajava.algorithms.dynamicprogramming;

public class Fibonacci {

    // Simple recursive Fibonacci calculation (inefficient due to repeated
    // calculations)
    public int fib(int n) {
        // Base case: return n when n is 0 or 1
        if (n <= 1)
            return n;
        // Recursively calculate fib(n) as fib(n-1) + fib(n-2)
        return fib(n - 1) + fib(n - 2);
    }

    // Helper method for Fibonacci calculation with memoization (top-down dynamic
    // programming)
    private int fibWithMemo(int[] memo, int n) {
        // Base case: return n when n is 0 or 1
        if (n <= 1)
            return n;

        // If the value is already computed, return it from memo
        if (memo[n] != 0)
            return memo[n];

        // Compute fib(n) recursively and store it in the memo array
        memo[n] = fibWithMemo(memo, n - 1) + fibWithMemo(memo, n - 2);
        return memo[n];
    }

    // Public method to initialize memo array and call the helper method
    public int fibWithMemo(int n) {
        // Create a memo array of size n+1 to store intermediate results
        int[] memo = new int[n + 1];
        // Start the memoized Fibonacci calculation
        return fibWithMemo(memo, n);
    }

    // Fibonacci calculation using tabulation (bottom-up dynamic programming)
    public int fibWithTabulation(int n) {
        // Base case: return n when n is 0 or 1
        if (n <= 1)
            return n;

        // Create an array to store Fibonacci numbers up to n
        int[] fib = new int[n + 1];
        fib[0] = 0; // Initialize base case fib(0) = 0
        fib[1] = 1; // Initialize base case fib(1) = 1

        // Calculate Fibonacci numbers iteratively from 2 to n
        for (int i = 2; i <= n; i++) {
            // Each fib(i) is the sum of the two preceding Fibonacci numbers
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        // Return the Fibonacci number for n
        return fib[n];
    }
}
