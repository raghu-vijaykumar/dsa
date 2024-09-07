package dsajava.datastructures.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnWeightedGraphTest {

    private UnWeightedGraph graph;

    @BeforeEach
    public void setup() {
        graph = new UnWeightedGraph();
    }

    @Test
    public void testAddVertex() {
        assertTrue(graph.addVertex("A"), "Adding vertex 'A' should return true.");
        assertFalse(graph.addVertex("A"), "Adding vertex 'A' again should return false.");
    }

    @Test
    public void testAddEdgeValidVertices() {
        graph.addVertex("A");
        graph.addVertex("B");
        assertTrue(graph.addEdge("A", "B"), "Adding an edge between 'A' and 'B' should return true.");
        assertEquals(1, graph.adjacencyList.get("A").size(), "'A' should have one adjacent vertex.");
        assertEquals(1, graph.adjacencyList.get("B").size(), "'B' should have one adjacent vertex.");
        assertTrue(graph.adjacencyList.get("A").contains("B"), "'A' should be connected to 'B'.");
        assertTrue(graph.adjacencyList.get("B").contains("A"), "'B' should be connected to 'A'.");
    }

    @Test
    public void testAddEdgeNonExistentVertices() {
        assertFalse(graph.addEdge("A", "B"), "Adding an edge between non-existent vertices should return false.");
    }

    @Test
    public void testAddEdgeSelfLoop() {
        graph.addVertex("A");
        assertFalse(graph.addEdge("A", "A"), "Adding an edge from 'A' to itself should return false.");
    }

    @Test
    public void testRemoveVertex() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");
        assertTrue(graph.removeVertex("A"), "Removing vertex 'A' should return true.");
        assertFalse(graph.adjacencyList.containsKey("A"), "'A' should no longer be in the graph.");
        assertFalse(graph.adjacencyList.get("B").contains("A"), "'B' should no longer be connected to 'A'.");
    }

    @Test
    public void testRemoveVertexNonExistent() {
        assertFalse(graph.removeVertex("A"), "Removing a non-existent vertex should return false.");
    }

    @Test
    public void testRemoveEdgeValid() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");
        assertTrue(graph.removeEdge("A", "B"), "Removing an edge between 'A' and 'B' should return true.");
        assertFalse(graph.adjacencyList.get("A").contains("B"), "'A' should no longer be connected to 'B'.");
        assertFalse(graph.adjacencyList.get("B").contains("A"), "'B' should no longer be connected to 'A'.");
    }

    @Test
    public void testRemoveEdgeNonExistentVertices() {
        assertFalse(graph.removeEdge("A", "B"), "Removing an edge between non-existent vertices should return false.");
    }

    @Test
    public void testRemoveEdgeNonExistentEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        assertFalse(graph.removeEdge("A", "B"), "Removing a non-existent edge should return false.");
    }

    @Test
    public void testRemoveEdgeSelfLoop() {
        graph.addVertex("A");
        assertFalse(graph.removeEdge("A", "A"), "Removing a self-loop should return false.");
    }

    @Test
    public void testRemoveEdgeOneVertexConnectedToMany() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");

        assertTrue(graph.removeEdge("A", "B"), "Removing edge 'A'-'B' should return true.");
        assertFalse(graph.adjacencyList.get("A").contains("B"), "'A' should not be connected to 'B' anymore.");
        assertTrue(graph.adjacencyList.get("A").contains("C"), "'A' should still be connected to 'C'.");
    }

}
