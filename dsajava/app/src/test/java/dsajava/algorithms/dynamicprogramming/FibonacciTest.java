package dsajava.algorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciTest {

    // Create an instance of Fibonacci class to test
    Fibonacci fibonacci = new Fibonacci();

    // Test the simple recursive Fibonacci method
    @Test
    public void testFib() {
        assertEquals(0, fibonacci.fib(0)); // Test fib(0) -> 0
        assertEquals(1, fibonacci.fib(1)); // Test fib(1) -> 1
        assertEquals(1, fibonacci.fib(2)); // Test fib(2) -> 1
        assertEquals(2, fibonacci.fib(3)); // Test fib(3) -> 2
        assertEquals(3, fibonacci.fib(4)); // Test fib(4) -> 3
        assertEquals(5, fibonacci.fib(5)); // Test fib(5) -> 5
        assertEquals(8, fibonacci.fib(6)); // Test fib(6) -> 8
    }

    // Test the Fibonacci method with memoization
    @Test
    public void testFibWithMemo() {
        assertEquals(0, fibonacci.fibWithMemo(0)); // Test fibWithMemo(0) -> 0
        assertEquals(1, fibonacci.fibWithMemo(1)); // Test fibWithMemo(1) -> 1
        assertEquals(1, fibonacci.fibWithMemo(2)); // Test fibWithMemo(2) -> 1
        assertEquals(2, fibonacci.fibWithMemo(3)); // Test fibWithMemo(3) -> 2
        assertEquals(3, fibonacci.fibWithMemo(4)); // Test fibWithMemo(4) -> 3
        assertEquals(5, fibonacci.fibWithMemo(5)); // Test fibWithMemo(5) -> 5
        assertEquals(8, fibonacci.fibWithMemo(6)); // Test fibWithMemo(6) -> 8
        assertEquals(55, fibonacci.fibWithMemo(10)); // Test fibWithMemo(10) -> 55
    }

    // Test the Fibonacci method with tabulation
    @Test
    public void testFibWithTabulation() {
        assertEquals(0, fibonacci.fibWithTabulation(0)); // Test fibWithTabulation(0) -> 0
        assertEquals(1, fibonacci.fibWithTabulation(1)); // Test fibWithTabulation(1) -> 1
        assertEquals(1, fibonacci.fibWithTabulation(2)); // Test fibWithTabulation(2) -> 1
        assertEquals(2, fibonacci.fibWithTabulation(3)); // Test fibWithTabulation(3) -> 2
        assertEquals(3, fibonacci.fibWithTabulation(4)); // Test fibWithTabulation(4) -> 3
        assertEquals(5, fibonacci.fibWithTabulation(5)); // Test fibWithTabulation(5) -> 5
        assertEquals(8, fibonacci.fibWithTabulation(6)); // Test fibWithTabulation(6) -> 8
        assertEquals(55, fibonacci.fibWithTabulation(10)); // Test fibWithTabulation(10) -> 55
        assertEquals(6765, fibonacci.fibWithTabulation(20)); // Test fibWithTabulation(20) -> 6765
    }
}
