package dsajava.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    List<Integer> heap = new ArrayList<>();

    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public void swap(int index1, int index2) {
        if (index1 > heap.size() - 1 || index2 > heap.size() - 1)
            return;
        int temp = heap.get(index2);
        heap.set(index2, heap.get(index1));
        heap.set(index1, temp);
    }

    public void insert(int value) {
        heap.add(value); // Add the new value to the heap
        int currentIndex = heap.size() - 1; // Index of the newly added value
        int parentIndex = getParentIndex(currentIndex); // Get parent index

        // Perform heapification (bubble-up) to maintain the heap property
        while (currentIndex != 0 && heap.get(currentIndex) > heap.get(parentIndex)) {
            swap(currentIndex, parentIndex); // Swap with parent if heap property is violated
            currentIndex = parentIndex; // Move to the parent index
            parentIndex = getParentIndex(currentIndex); // Update parent index for the next iteration
        }
    }

    public Integer remove() {
        if (heap.size() == 0)
            return null;
        if (heap.size() == 1)
            return heap.remove(0);

        Integer maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkdown(0);
        return maxValue;
    }

    private void sinkdown(int index) {
        int maxIndex = index;
        while (true) {
            int leftIndex = getLeftChildIndex(maxIndex);
            int rightIndex = getRightChildIndex(maxIndex);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (maxIndex != index) {
                swap(maxIndex, index);
                index = maxIndex;
            } else {
                return;
            }

        }

    }

}
