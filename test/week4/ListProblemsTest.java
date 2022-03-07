package week4;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ListProblemsTest {

    @Test
    public void testABCD() {
        List<String> expected = List.of("A", "B", "C", "D");
        List<String> actual = ListProblems.makeABCD();
        assertEquals(expected, actual);
        actual.add("E");
        assertEquals("Should be able to modify result list.", 5, actual.size());
    }

    @Test
    public void testReverseList() {
        assertEquals(List.of(), ListProblems.reverseList(List.of()));
        assertEquals(List.of("A"), ListProblems.reverseList(List.of("A")));
        assertEquals(List.of("B", "A"), ListProblems.reverseList(List.of("A", "B")));
        assertEquals(List.of("D", "C", "B", "A"), ListProblems.reverseList(ListProblems.makeABCD()));
    }

    @Test
    public void testFindMinimumPosition() {
        assertEquals(-1, ListProblems.findMinimumPosition(List.of()));
        assertEquals(0, ListProblems.findMinimumPosition(List.of(1.0)));
        assertEquals(0, ListProblems.findMinimumPosition(List.of(1.0, 2.0, 3.0)));
        assertEquals(1, ListProblems.findMinimumPosition(List.of(3.0, 1.0, 2.0)));
        assertEquals(1, ListProblems.findMinimumPosition(List.of(3.0, 1.0, 2.0, 4.0)));
        assertEquals(4, ListProblems.findMinimumPosition(List.of(3.0, 1.0, 2.0, 4.0, 1.0)));
    }

    @Test
    public void testMultiplyItems() {
        assertEquals(List.of(), ListProblems.multiplyItems(List.of(), 2));
        assertEquals(List.of(2), ListProblems.multiplyItems(List.of(1), 2));
        assertEquals(List.of(2, 10, 4), ListProblems.multiplyItems(List.of(1, 5, 2), 2));
        assertEquals(List.of(10, 50, 20), ListProblems.multiplyItems(List.of(1, 5, 2), 10));
    }
}
