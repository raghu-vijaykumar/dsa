package dsajava.algorithms.sorting.array;

import java.util.Arrays;

public class MergeSort {

    // Merges two sorted arrays into a single sorted array
    public int[] merge(int[] sortedArray1, int[] sortedArray2) {
        // Create a new array to hold the combined sorted elements
        int[] combined = new int[sortedArray1.length + sortedArray2.length];

        // Initialize indices for combined array, sortedArray1, and sortedArray2
        int index = 0, i = 0, j = 0;

        // Traverse both arrays, comparing elements and adding the smaller one to the
        // combined array
        while (i < sortedArray1.length && j < sortedArray2.length) {
            if (sortedArray1[i] < sortedArray2[j]) {
                combined[index++] = sortedArray1[i++]; // Add element from sortedArray1 and increment index
            } else {
                combined[index++] = sortedArray2[j++]; // Add element from sortedArray2 and increment index
            }
        }

        // Add any remaining elements from sortedArray1 (if any)
        while (i < sortedArray1.length) {
            combined[index++] = sortedArray1[i++];
        }

        // Add any remaining elements from sortedArray2 (if any)
        while (j < sortedArray2.length) {
            combined[index++] = sortedArray2[j++];
        }

        // Return the fully combined and sorted array
        return combined;
    }

    // Recursively divides the array into halves, sorts, and merges them
    public int[] mergeSort(int[] array) {
        // Base case: if the array has only one element, it's already sorted
        if (array.length == 1)
            return array;

        // Find the middle index of the array to split it into two halves
        int mid = array.length / 2;

        // Recursively sort the left half of the array
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));

        // Recursively sort the right half of the array
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        // Merge the two sorted halves and return the final sorted array
        return merge(left, right);
    }
}
