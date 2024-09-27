package dsajava.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permuteIterative(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permutations.add(new ArrayList<>());

        for (int n : nums) {
            List<List<Integer>> stepResults = new ArrayList<>();
            for (List<Integer> step : permutations) {
                for (int i = 0; i <= step.size(); i++) {
                    List<Integer> stepCopy = new ArrayList<>(step);
                    stepCopy.add(i, n);
                    stepResults.add(stepCopy);
                }
            }
            permutations = stepResults;
        }
        return permutations;
    }

    public static List<List<Integer>> permuteRecursive(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permutations.add(new ArrayList<>());
        permutations = permuteRecursive(permutations, nums, 0);
        return permutations;
    }

    private static List<List<Integer>> permuteRecursive(List<List<Integer>> permutations, int[] nums,
            int currentIndex) {
        if (currentIndex == nums.length)
            return permutations;

        List<List<Integer>> stepResults = new ArrayList<>();
        for (List<Integer> step : permutations) {
            for (int i = 0; i <= step.size(); i++) {
                List<Integer> stepCopy = new ArrayList<>(step);
                stepCopy.add(i, nums[currentIndex]);
                stepResults.add(stepCopy);
            }
        }
        return permuteRecursive(stepResults, nums, currentIndex + 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        System.out.println(permuteIterative(nums));
        System.out.println(permuteRecursive(nums));
    }
}
