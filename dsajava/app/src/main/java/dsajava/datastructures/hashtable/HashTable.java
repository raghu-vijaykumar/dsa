package dsajava.datastructures.hashtable;

public class HashTable {

    // Define the size of the hash table
    int length = 7;
    Node[] dataMap;

    // Inner class to represent each node in the hash table
    public class Node {
        String key; // Key for the node
        int value; // Value associated with the key
        Node next; // Reference to the next node (for handling collisions)

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the hash table
    public HashTable() {
        dataMap = new Node[length]; // Initialize the dataMap array with the specified length
    }

    // Hash function to compute the index for a given key
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray(); // Convert the key to a character array
        for (int i = 0; i < keyChars.length; i++) {
            // Compute hash by adding ASCII value of each character multiplied by 37
            hash += (keyChars[i] * 37) % dataMap.length;
        }
        return hash; // Return the computed hash value
    }

    // Method to add a key-value pair to the hash table
    public void put(String key, int value) {
        int hash = hash(key); // Compute the hash for the given key
        Node newNode = new Node(key, value); // Create a new node with the provided key and value
        if (dataMap[hash] == null) { // Check if there's no collision at the computed index
            dataMap[hash] = newNode; // Add the new node directly to the dataMap
        } else {
            // Handle collisions using chaining
            Node temp = dataMap[hash];
            // Traverse to the end of the linked list at this index
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode; // Append the new node to the end of the linked list
        }
    }

    // Method to retrieve a value by key from the hash table
    public int get(String key) {
        int hash = hash(key); // Compute the hash for the given key
        Node temp = dataMap[hash]; // Start at the head of the linked list at the computed index
        // Traverse the linked list to find the node with the matching key
        while (temp != null) {
            if (key.equals(temp.key)) { // Compare keys (use .equals() for string comparison)
                return temp.value; // Return the value if the key matches
            }
            temp = temp.next; // Move to the next node in the list
        }
        return 0; // Return 0 if the key is not found in the hash table
    }

}
