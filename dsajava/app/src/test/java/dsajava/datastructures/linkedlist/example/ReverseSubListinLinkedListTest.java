package dsajava.datastructures.linkedlist.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReverseSubListinLinkedListTest {

    private ReverseSubListinLinkedList list;

    @BeforeEach
    public void setUp() {
        list = new ReverseSubListinLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5); // List: 1 > 2 > 3 > 4 > 5
    }

    @Test
    public void testReverseBetween_ValidIndices() {
        list.reverseBetween(1, 3); // Reversing from index 1 to 3 should result in: 1 > 4 > 3 > 2 > 5
        String expected = "1 4 3 2 5";
        assertEquals(expected, getListAsString(list), "The list was not correctly reversed between indices 1 and 3.");
    }

    @Test
    public void testReverseBetween_EntireList() {
        list.reverseBetween(0, 4); // Reversing entire list should result in: 5 > 4 > 3 > 2 > 1
        String expected = "5 4 3 2 1";
        assertEquals(expected, getListAsString(list), "The entire list was not correctly reversed.");
    }

    @Test
    public void testReverseBetween_SingleElement() {
        list.reverseBetween(2, 2); // Reversing a single element should result in no change: 1 > 2 > 3 > 4 > 5
        String expected = "1 2 3 4 5";
        assertEquals(expected, getListAsString(list), "Reversing a single element caused an unexpected change.");
    }

    @Test
    public void testReverseBetween_StartEqualsEnd() {
        list.reverseBetween(3, 3); // Reversing when startIndex == endIndex should result in no change
        String expected = "1 2 3 4 5";
        assertEquals(expected, getListAsString(list),
                "Reversing a sublist with equal start and end index caused a change.");
    }

    @Test
    public void testReverseBetween_EmptyList() {
        ReverseSubListinLinkedList emptyList = new ReverseSubListinLinkedList();
        emptyList.reverseBetween(0, 1); // Reverse on an empty list should result in no change
        assertNull(emptyList.head, "The list is not empty as expected.");
    }

    // Helper method to get the list as a string
    private String getListAsString(ReverseSubListinLinkedList list) {
        StringBuilder sb = new StringBuilder();
        ReverseSubListinLinkedList.Node temp = list.head;
        while (temp != null) {
            sb.append(temp.value).append(" ");
            temp = temp.next;
        }
        return sb.toString().trim();
    }
}
