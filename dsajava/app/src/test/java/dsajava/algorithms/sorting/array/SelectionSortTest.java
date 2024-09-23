package dsajava.algorithms.sorting.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SelectionSortTest {

    @Test
    public void testSortedArray() {
        int[] array = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        SelectionSort.sort(array);
        assertArrayEquals(expected, array, "The array should remain sorted.");
    }

    @Test
    public void testReverseSortedArray() {
        int[] array = { 5, 4, 3, 2, 1 };
        int[] expected = { 1, 2, 3, 4, 5 };
        SelectionSort.sort(array);
        assertArrayEquals(expected, array, "The array should be sorted in ascending order.");
    }

    @Test
    public void testUnsortedArray() {
        int[] array = { 3, 1, 4, 1, 5, 9, 2 };
        int[] expected = { 1, 1, 2, 3, 4, 5, 9 };
        SelectionSort.sort(array);
        assertArrayEquals(expected, array, "The array should be sorted in ascending order.");
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] array = { 3, 3, 2, 1, 2, 1 };
        int[] expected = { 1, 1, 2, 2, 3, 3 };
        SelectionSort.sort(array);
        assertArrayEquals(expected, array, "The array with duplicates should be sorted.");
    }

    @Test
    public void testSingleElementArray() {
        int[] array = { 7 };
        int[] expected = { 7 };
        SelectionSort.sort(array);
        assertArrayEquals(expected, array, "An array with a single element should remain unchanged.");
    }

    @Test
    public void testEmptyArray() {
        int[] array = {};
        int[] expected = {};
        SelectionSort.sort(array);
        assertArrayEquals(expected, array, "An empty array should remain unchanged.");
    }
}
