package dsajava.datastructures.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthLargestElement {

    public static Integer kthLargestElement(int[] nums, int k) {
        if (k > nums.length)
            return null;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        pQueue.addAll(Arrays.stream(nums).boxed()
                .collect(Collectors.toList()));

        int kth = -1;
        while (!pQueue.isEmpty() && k > 0) {
            kth = pQueue.remove();
            k--;
        }

        return kth;
    }

}
