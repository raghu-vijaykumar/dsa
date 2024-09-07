package dsajava.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class UnWeightedGraph {

    // HashMap to store adjacency list for each vertex.
    // Key is the vertex and value is a list of connected vertices.
    HashMap<String, ArrayList<String>> adjacencyList = new HashMap<>();

    // Adds a vertex to the graph. Returns false if the vertex already exists.
    public boolean addVertex(String vertex) {
        if (adjacencyList.containsKey(vertex)) // Check if vertex already exists.
            return false;
        adjacencyList.put(vertex, new ArrayList<>()); // Add vertex with an empty adjacency list.
        return true;
    }

    // Adds an undirected edge between two vertices. Returns false if either vertex
    // is not found.
    public boolean addEdge(String vertex1, String vertex2) {
        if (vertex1.equals(vertex2)) // Prevent self-loops
            return false;
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2)) // Check if verticies exist.
            return false;
        adjacencyList.get(vertex1).add(vertex2); // Add vertex2 to the adjacency list of vertex1.
        adjacencyList.get(vertex2).add(vertex1); // Add vertex1 to the adjacency list of vertex2.
        return true;
    }

    // Removes a vertex and its associated edges from the graph. Returns false if
    // the vertex is not found.
    public boolean removeVertex(String vertex) {
        if (!adjacencyList.containsKey(vertex)) // Check if vertex exists.
            return false;

        // Iterate over the adjacency list of the vertex and remove the edges from each
        // connected vertex.
        for (String otherVertex : adjacencyList.get(vertex)) {
            adjacencyList.get(otherVertex).remove(vertex); // Remove the vertex from otherVertex's list.
        }
        adjacencyList.remove(vertex); // Finally, remove the vertex itself from the adjacency list.
        return true;
    }

    // Removes an undirected edge between two vertices. Returns false if either
    // vertex is not found.
    public boolean removeEdge(String vertex1, String vertex2) {
        if (vertex1.equals(vertex2)) // Prevent self-loops
            return false;
        if (!adjacencyList.containsKey(vertex1)) // Check if vertex1 exists.
            return false;
        if (!adjacencyList.containsKey(vertex2)) // Check if vertex2 exists.
            return false;

        if (!adjacencyList.get(vertex1).contains(vertex2) || !adjacencyList.get(vertex2).contains(vertex1)) {
            return false;
        }
        // Remove vertex2 from vertex1's adjacency list and vice versa.
        adjacencyList.get(vertex1).remove(vertex2);
        adjacencyList.get(vertex2).remove(vertex1);
        return true;
    }

}
