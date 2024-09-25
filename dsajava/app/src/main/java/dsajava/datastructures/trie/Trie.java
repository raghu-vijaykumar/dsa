package dsajava.datastructures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public void insert(String word) {
        TrieNode currNode = root;
        for (Character c : word.toCharArray()) {
            currNode = currNode.children.computeIfAbsent(c, x -> new TrieNode());
        }
        currNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode currNode = root;
        for (Character c : word.toCharArray()) {
            currNode = currNode.children.get(c);
            if (currNode == null) {
                return false;
            }
        }
        return currNode.isEndOfWord;
    }

    public boolean delete(String word) {
        return delete(root, word, 0);

    }

    private boolean delete(TrieNode currentNode, String word, int i) {
        // Base Case
        if (i == word.length()) {

            if (!currentNode.isEndOfWord)
                return false;
            System.out.println("Word: " + word + " Found, Marking end of word as false");
            currentNode.isEndOfWord = false;
            return currentNode.children.isEmpty();

        }

        // Recursion
        Character c = word.charAt(i);
        TrieNode nextNode = currentNode.children.get(c);
        if (nextNode == null) {
            return false;
        }

        boolean shouldDelete = delete(nextNode, word, i + 1);

        if (shouldDelete) {
            System.out.println("Removing node " + c + " as there are no children");
            currentNode.children.remove(c);

            return currentNode.children.isEmpty() && !currentNode.isEndOfWord;
        } else {
            System.out.println("Not removing node " + c + " as there are children");
        }

        return false;
    }

    public List<String> prefixSearch(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode currentNode = root;
        for (Character c : prefix.toCharArray()) {
            currentNode = currentNode.children.get(c);
        }

        if (currentNode.isEndOfWord)
            results.add(prefix);

        dfs(results, currentNode, prefix);
        return results;

    }

    private void dfs(List<String> results, TrieNode node, String prefix) {
        if (node == null)
            return;

        for (Map.Entry<Character, TrieNode> e : node.children.entrySet()) {
            if (e.getValue().isEndOfWord)
                results.add(prefix + e.getKey());

            dfs(results, e.getValue(), prefix + e.getKey());
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apps");
        trie.insert("app");
        trie.insert("axp");
        trie.insert("axasfsa");
        trie.insert("api");
        trie.insert("bbb");
        System.out.println(trie.search("app"));
        System.out.println(trie.delete("app"));
        System.out.println(trie.search("api"));

        System.out.print(trie.prefixSearch("ax"));
    }

}
