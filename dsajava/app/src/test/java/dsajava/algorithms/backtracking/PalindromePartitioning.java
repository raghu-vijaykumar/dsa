package dsajava.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> partitionSet = new ArrayList<>();
        backtrack(partitionSet, new ArrayList<>(), s, 0);
        return partitionSet;
    }

    public void backtrack(List<List<String>> partitionSet, List<String> stepResult, String word, int startIndex) {
        if (startIndex == word.length()) {
            partitionSet.add(new ArrayList<>(stepResult));
            return;
        }

        for (int i = startIndex; i < word.length(); i++) {
            String partition = word.substring(startIndex, i + 1);
            if (isPalindrome(partition)) {
                stepResult.add(partition);
                backtrack(partitionSet, stepResult, word, i + 1);
                stepResult.remove(stepResult.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String word) {
        int n = word.length();
        for (int i = 0; i < n / 2; i++) {
            if (word.charAt(i) != word.charAt(n - i - 1))
                return false;
        }
        return true;
    }

}
