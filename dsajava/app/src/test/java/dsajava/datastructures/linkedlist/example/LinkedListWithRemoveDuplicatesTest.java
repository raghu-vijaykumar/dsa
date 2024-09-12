package dsajava.datastructures.linkedlist.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListWithRemoveDuplicatesTest {

    private LinkedListWithRemoveDuplicates list;

    @BeforeEach
    public void setUp() {
        list = new LinkedListWithRemoveDuplicates();
    }

    @Test
    public void testRemoveDuplicates_EmptyList() {
        list.removeDuplicates();
        assertEquals(0, list.getLength(), "The length of an empty list should remain 0.");
    }

    @Test
    public void testRemoveDuplicates_SingleElementList() {
        list.append(1); // List: [1]
        list.removeDuplicates();
        assertEquals(1, list.getLength(), "A single-element list should not change after removing duplicates.");
        assertEquals("1 ", listToString(list), "The list should remain [1].");
    }

    @Test
    public void testRemoveDuplicates_NoDuplicates() {
        list.append(1); // List: [1]
        list.append(2); // List: [1, 2]
        list.append(3); // List: [1, 2, 3]
        list.removeDuplicates();
        assertEquals(3, list.getLength(), "A list with no duplicates should not change.");
        assertEquals("1 2 3 ", listToString(list), "The list should remain [1, 2, 3].");
    }

    @Test
    public void testRemoveDuplicates_WithDuplicates() {
        list.append(1); // List: [1]
        list.append(2); // List: [1, 2]
        list.append(2); // List: [1, 2, 2]
        list.append(3); // List: [1, 2, 2, 3]
        list.append(3); // List: [1, 2, 2, 3, 3]
        list.removeDuplicates();
        assertEquals(3, list.getLength(), "The list length should be reduced to 3 after removing duplicates.");
        assertEquals("1 2 3 ", listToString(list), "The list should become [1, 2, 3] after removing duplicates.");
    }

    @Test
    public void testRemoveDuplicates_AllElementsSame() {
        list.append(1); // List: [1]
        list.append(1); // List: [1, 1]
        list.append(1); // List: [1, 1, 1]
        list.removeDuplicates();
        assertEquals(1, list.getLength(), "The list length should be 1 after removing all duplicates.");
        assertEquals("1 ", listToString(list), "The list should contain only [1] after removing all duplicates.");
    }

    @Test
    public void testRemoveDuplicates_LargeListWithDuplicates() {
        list.append(5); // List: [5]
        list.append(1); // List: [5, 1]
        list.append(2); // List: [5, 1, 2]
        list.append(2); // List: [5, 1, 2, 2]
        list.append(3); // List: [5, 1, 2, 2, 3]
        list.append(5); // List: [5, 1, 2, 2, 3, 5]
        list.removeDuplicates();
        assertEquals(4, list.getLength(), "The list length should be reduced to 4 after removing duplicates.");
        assertEquals("5 1 2 3 ", listToString(list), "The list should become [5, 1, 2, 3] after removing duplicates.");
    }

    // Utility method to convert the list to a string for comparison
    private String listToString(LinkedListWithRemoveDuplicates list) {
        StringBuilder sb = new StringBuilder();
        LinkedListWithRemoveDuplicates.Node current = list.head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}
