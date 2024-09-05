package dsajava.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxHeapTest {

    private MaxHeap heap;

    @BeforeEach
    public void setup() {
        heap = new MaxHeap();
    }

    @Test
    public void testInsertSingleElement() {
        heap.insert(10);
        assertEquals(10, heap.remove(), "Removing the only element should return 10.");
    }

    @Test
    public void testInsertMultipleElements() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        assertEquals(20, heap.remove(), "After multiple inserts, max element should be 20.");
    }

    @Test
    public void testHeapPropertyAfterInsertions() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);
        assertEquals(30, heap.remove(), "After inserts, max element should be 30.");
        assertEquals(20, heap.remove(), "After removing max, next max should be 20.");
    }

    @Test
    public void testRemoveMaxElement() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);

        assertEquals(30, heap.remove(), "Max element should be removed, which is 30.");
        assertEquals(20, heap.remove(), "After removal, max element should be 20.");
        assertEquals(10, heap.remove(), "Next removal should return 10.");
        assertEquals(5, heap.remove(), "Next removal should return 5.");
    }

    @Test
    public void testRemoveMultipleTimes() {
        heap.insert(40);
        heap.insert(20);
        heap.insert(30);
        heap.insert(10);
        heap.insert(5);

        assertEquals(40, heap.remove(), "First removal should return 40.");
        assertEquals(30, heap.remove(), "Second removal should return 30.");
        assertEquals(20, heap.remove(), "Third removal should return 20.");
        assertEquals(10, heap.remove(), "Fourth removal should return 10.");
        assertEquals(5, heap.remove(), "Fifth removal should return 5.");
        assertNull(heap.remove(), "Heap should now be empty and return null.");
    }

    @Test
    public void testRemoveFromEmptyHeap() {
        assertNull(heap.remove(), "Removing from an empty heap should return null.");
    }

    @Test
    public void testRemoveSingleElementHeap() {
        heap.insert(50);
        assertEquals(50, heap.remove(), "Removing from a single-element heap should return 50.");
        assertNull(heap.remove(), "After removing the only element, heap should be empty.");
    }

    @Test
    public void testSinkDownAfterRemove() {
        heap.insert(50);
        heap.insert(40);
        heap.insert(45);
        heap.insert(30);
        heap.insert(20);

        heap.remove(); // Remove max (50), 20 should replace 50 and sink down
        assertEquals(45, heap.remove(), "After sinking down, max should now be 45.");
        assertEquals(40, heap.remove(), "After removal, next max should be 40.");
        assertEquals(30, heap.remove(), "After removal, next max should be 30.");
    }

}
