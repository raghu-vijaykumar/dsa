package dsajava.datastructures.linkedlist.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MiddleoftheLinkedListTest {

    private MiddleoftheLinkedList list;

    @BeforeEach
    public void setUp() {
        list = new MiddleoftheLinkedList();
    }

    @Test
    public void testMiddleNode_EmptyList() {
        assertNull(list.middleNode(), "Middle of an empty list should be null.");
    }

    @Test
    public void testMiddleNode_OneElement() {
        list.append(1); // List: [1]
        assertEquals(1, list.middleNode().value, "Middle of list with one element should be 1.");
    }

    @Test
    public void testMiddleNode_OddNumberOfElements() {
        list.append(1); // List: [1]
        list.append(2); // List: [1, 2]
        list.append(3); // List: [1, 2, 3]
        assertEquals(2, list.middleNode().value, "Middle of list [1, 2, 3] should be 2.");
    }

    @Test
    public void testMiddleNode_EvenNumberOfElements() {
        list.append(1); // List: [1]
        list.append(2); // List: [1, 2]
        list.append(3); // List: [1, 2, 3]
        list.append(4); // List: [1, 2, 3, 4]
        assertEquals(3, list.middleNode().value, "Middle of list [1, 2, 3, 4] should be 3.");
    }

    @Test
    public void testMiddleNode_LargeOddNumberOfElements() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5); // List: [1, 2, 3, 4, 5]
        assertEquals(3, list.middleNode().value, "Middle of list [1, 2, 3, 4, 5] should be 3.");
    }

    @Test
    public void testMiddleNode_LargeEvenNumberOfElements() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6); // List: [1, 2, 3, 4, 5, 6]
        assertEquals(4, list.middleNode().value, "Middle of list [1, 2, 3, 4, 5, 6] should be 4.");
    }
}
