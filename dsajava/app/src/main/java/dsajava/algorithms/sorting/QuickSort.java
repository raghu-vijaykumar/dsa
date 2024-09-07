package dsajava.algorithms.sorting;

public class QuickSort {

    // Public method to start the quick sort algorithm
    public static void sort(int[] array) {
        // Calling the recursive quickSort function with the entire array
        quickSort(array, 0, array.length - 1);
    }

    // Recursive quickSort method that sorts the array within a given range
    private static void quickSort(int[] array, int start, int end) {
        // Base case: If the start index is less than the end index, continue sorting
        if (start < end) {
            // Partition the array around a pivot and get the pivot index
            int pivotIndex = pivot(array, start, end);
            // Recursively sort the left part of the array (elements smaller than the pivot)
            quickSort(array, start, pivotIndex - 1);
            // Recursively sort the right part of the array (elements larger than the pivot)
            quickSort(array, pivotIndex + 1, end);
        }
    }

    // Method to partition the array and place the pivot element in its correct
    // position
    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex; // Initialize swapIndex to the start of the partition
        // Loop through the array from the next element after pivot to the end of the
        // partition
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            // If the current element is smaller than the pivot element
            if (array[i] < array[pivotIndex]) {
                swapIndex++; // Increment swapIndex
                // Swap the current element with the element at the swapIndex if they are
                // different
                if (swapIndex != i)
                    swap(array, swapIndex, i);
            }
        }
        // After the loop, swap the pivot element with the element at the swapIndex
        swap(array, pivotIndex, swapIndex);
        // Return the new index of the pivot element
        return swapIndex;
    }

    // Method to swap two elements in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i]; // Store the element at index i in a temporary variable
        array[i] = array[j]; // Set the element at index i to the element at index j
        array[j] = temp; // Set the element at index j to the stored element in temp
    }
}
