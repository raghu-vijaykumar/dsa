package dsajava.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MergeSortTest {

    MergeSort mergeSort = new MergeSort();

    @Test
    public void testMergeSort_AlreadySorted() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };
        int[] result = mergeSort.mergeSort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeSort_Unsorted() {
        int[] input = { 5, 2, 9, 1, 5, 6 };
        int[] expected = { 1, 2, 5, 5, 6, 9 };
        int[] result = mergeSort.mergeSort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeSort_SingleElement() {
        int[] input = { 42 };
        int[] expected = { 42 };
        int[] result = mergeSort.mergeSort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeSort_WithNegativeNumbers() {
        int[] input = { -3, -1, -4, -2, 0 };
        int[] expected = { -4, -3, -2, -1, 0 };
        int[] result = mergeSort.mergeSort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMergeSort_WithDuplicates() {
        int[] input = { 4, 5, 6, 5, 4, 3 };
        int[] expected = { 3, 4, 4, 5, 5, 6 };
        int[] result = mergeSort.mergeSort(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMerge() {
        int[] array1 = { 1, 3, 5 };
        int[] array2 = { 2, 4, 6 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        int[] result = mergeSort.merge(array1, array2);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMerge_WithUnevenArrays() {
        int[] array1 = { 1, 5, 9 };
        int[] array2 = { 2, 6 };
        int[] expected = { 1, 2, 5, 6, 9 };
        int[] result = mergeSort.merge(array1, array2);
        assertArrayEquals(expected, result);
    }
}
