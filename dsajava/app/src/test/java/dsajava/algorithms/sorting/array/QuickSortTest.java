package dsajava.algorithms.sorting.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class QuickSortTest {

    @Test
    void testSort_withRandomArray() {
        int[] array = { 3, 6, 8, 10, 1, 2, 1 };
        int[] expected = { 1, 1, 2, 3, 6, 8, 10 };
        QuickSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testSort_withSortedArray() {
        int[] array = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        QuickSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testSort_withReverseSortedArray() {
        int[] array = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        QuickSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testSort_withAllEqualElements() {
        int[] array = { 7, 7, 7, 7, 7 };
        int[] expected = { 7, 7, 7, 7, 7 };
        QuickSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testSort_withSingleElement() {
        int[] array = { 42 };
        int[] expected = { 42 };
        QuickSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testSort_withEmptyArray() {
        int[] array = {};
        int[] expected = {};
        QuickSort.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testSort_withLargeArray() {
        int[] array = { 100, 23, 45, 67, 12, 2, 87, 66, 100, 3 };
        int[] expected = { 2, 3, 12, 23, 45, 66, 67, 87, 100, 100 };
        QuickSort.sort(array);
        assertArrayEquals(expected, array);
    }
}
