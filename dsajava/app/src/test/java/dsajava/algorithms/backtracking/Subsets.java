package dsajava.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> step = new ArrayList<>();
        dfs(nums, step, 0);

        return results;
    }

    public void dfs(int[] nums, List<Integer> stepResult, int index) {
        if (index == nums.length) {
            results.add(new ArrayList<>(stepResult));
            return;
        }

        dfs(nums, new ArrayList<>(stepResult), index + 1);
        stepResult.add(nums[index]);
        dfs(nums, new ArrayList<>(stepResult), index + 1);
    }

}
