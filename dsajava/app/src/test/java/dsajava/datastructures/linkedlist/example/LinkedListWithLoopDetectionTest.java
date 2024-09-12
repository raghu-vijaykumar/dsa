package dsajava.datastructures.linkedlist.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListWithLoopDetectionTest {

    private LinkedListWithLoopDetection list;

    @BeforeEach
    public void setUp() {
        list = new LinkedListWithLoopDetection();
    }

    @Test
    public void testHasLoop_EmptyList() {
        assertFalse(list.hasLoop(), "An empty list should not have a loop.");
    }

    @Test
    public void testHasLoop_SingleElementList_NoLoop() {
        list.append(1); // List: [1]
        assertFalse(list.hasLoop(), "A single-element list should not have a loop.");
    }

    @Test
    public void testHasLoop_TwoElementList_NoLoop() {
        list.append(1); // List: [1]
        list.append(2); // List: [1, 2]
        assertFalse(list.hasLoop(), "A list with two elements should not have a loop.");
    }

    @Test
    public void testHasLoop_ListWithLoop() {
        list.append(1); // List: [1]
        list.append(2); // List: [1, 2]
        list.append(3); // List: [1, 2, 3]
        list.append(4); // List: [1, 2, 3, 4]
        list.append(5); // List: [1, 2, 3, 4, 5]

        list.createLoop(2); // Creates a loop where the last node points to node with value 3

        assertTrue(list.hasLoop(), "The list should have a loop.");
    }

    @Test
    public void testHasLoop_ListWithoutLoop() {
        list.append(1); // List: [1]
        list.append(2); // List: [1, 2]
        list.append(3); // List: [1, 2, 3]
        list.append(4); // List: [1, 2, 3, 4]
        list.append(5); // List: [1, 2, 3, 4, 5]

        assertFalse(list.hasLoop(), "The list should not have a loop.");
    }

    @Test
    public void testHasLoop_ListWithLoopAtHead() {
        list.append(1); // List: [1]
        list.append(2); // List: [1, 2]
        list.append(3); // List: [1, 2, 3]
        list.append(4); // List: [1, 2, 3, 4]
        list.append(5); // List: [1, 2, 3, 4, 5]

        list.createLoop(0); // Creates a loop where the last node points to the head

        assertTrue(list.hasLoop(), "The list should have a loop at the head.");
    }

    @Test
    public void testHasLoop_ListWithLoopInMiddle() {
        list.append(1); // List: [1]
        list.append(2); // List: [1, 2]
        list.append(3); // List: [1, 2, 3]
        list.append(4); // List: [1, 2, 3, 4]
        list.append(5); // List: [1, 2, 3, 4, 5]

        list.createLoop(1); // Creates a loop where the last node points to the node with value 2

        assertTrue(list.hasLoop(), "The list should have a loop in the middle.");
    }
}
