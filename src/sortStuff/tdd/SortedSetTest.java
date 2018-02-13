package sortStuff.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SortedSetTest {
    private SortedSet<String> setWithoutComparator;
    private SortedSet<String> setWithComparator;

    @Before
    public void setUp() {
        setWithoutComparator = new SortedSet<>();
        Comparator<String> alwaysEqualComparator = (o1, o2) -> 0;
        setWithComparator = new SortedSet<>(alwaysEqualComparator);
    }

    @Test
    public void emptySet_isEmpty_True() {
        assertTrue(setWithoutComparator.isEmpty());
    }

    @Test
    public void emptySet_size_zero() {
        assertEquals(0, setWithoutComparator.size());
    }

    @Test
    public void noArgConstructor_getComparator_Null() {
        assertNull(setWithoutComparator.getComparator());
    }

    @Test
    public void oneArgConstructor_getComparator_NotNull() {
        assertNotNull(setWithComparator.getComparator());
    }

    @Test (expected = NoSuchElementException.class)
    public void emptySet_first_throwsNoSuchElementException() {
        setWithoutComparator.first();
    }

    @Test (expected = NoSuchElementException.class)
    public void emptySet_last_throwsNoSuchElementException() {
        setWithoutComparator.last();
    }

    @Test
    public void emptySet_addOneElement_notEmpty() {
        setWithoutComparator.add("F");
        assertFalse(setWithoutComparator.isEmpty());
    }

    @Test
    public void emptySetAddOneElement_size_one() {
        setWithoutComparator.add("F");
        assertEquals(1, setWithoutComparator.size());
    }
}