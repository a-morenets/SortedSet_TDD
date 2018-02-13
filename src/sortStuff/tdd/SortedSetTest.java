package sortStuff.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SortedSetTest {
    private static final String ITEM_FIRST = "A";
    private static final String ITEM_LAST = "Z";
    private static final String ITEM_F = "F";
    private static final String ITEM_L = "L";
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
    public void emptySet_size_0() {
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
    public void emptySet_first_throwNoSuchElementException() {
        setWithoutComparator.first();
    }

    @Test (expected = NoSuchElementException.class)
    public void emptySet_last_throwNoSuchElementException() {
        setWithoutComparator.last();
    }

    @Test
    public void emptySet_addOneItem_notEmpty() {
        setWithoutComparator.add(ITEM_F);
        assertFalse(setWithoutComparator.isEmpty());
    }

    @Test
    public void emptySet_addOneItem_size_1() {
        setWithoutComparator.add(ITEM_F);
        assertEquals(1, setWithoutComparator.size());
    }

    @Test
    public void emptySet_addOneItem_first_addedElement() {
        final String addedItem = ITEM_F;
        setWithoutComparator.add(addedItem);
        assertEquals(addedItem, setWithoutComparator.first());
    }

    @Test
    public void emptySet_addOneItem_last_addedElement() {
        final String addedItem = ITEM_L;
        setWithoutComparator.add(addedItem);
        assertEquals(addedItem, setWithoutComparator.last());
    }

    @Test
    public void emptySet_addTwoNonEqualItems_size_2() {
        setWithoutComparator.add(ITEM_F);
        setWithoutComparator.add(ITEM_L);
        assertEquals(2, setWithoutComparator.size());
    }

    @Test
    public void emptySet_addAnItem_True() {
        assertTrue(setWithoutComparator.add(ITEM_F));
    }

    @Test
    public void set_addTwoEqualItems_False() {
        setWithoutComparator.add(ITEM_F);
        assertFalse(setWithoutComparator.add(ITEM_F));
    }

    @Test
    public void emptySet_addAthenZ_first_A() {
        setWithoutComparator.add(ITEM_FIRST);
        setWithoutComparator.add(ITEM_LAST);
        assertEquals(ITEM_FIRST, setWithoutComparator.first());
    }

    @Test
    public void emptySet_addZthenA_first_A() {
        setWithoutComparator.add(ITEM_LAST);
        setWithoutComparator.add(ITEM_FIRST);
        assertEquals(ITEM_FIRST, setWithoutComparator.first());
    }
}