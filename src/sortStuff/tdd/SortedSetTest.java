package sortStuff.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SortedSetTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testEmptySet_isEmpty_True() {
        SortedSet set = new SortedSet();
        assertTrue(set.isEmpty());
    }
}