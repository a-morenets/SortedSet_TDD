package sortStuff.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedSetTest {

    private SortedSet set;

    @Before
    public void setUp() {
        set = new SortedSet();
    }

    @Test
    public void emptySet_isEmpty_True() {
        assertTrue(set.isEmpty());
    }

    @Test
    public void emptySet_size_zero() {
        assertEquals(0, set.size());
    }
}