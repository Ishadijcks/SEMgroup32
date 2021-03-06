package test.logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.log.LogFilters;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class LogFiltersTest {

    private LogFilters filter;

    @Before
    public void init() {
        filter = new LogFilters();
    }

    @Test
    public void testLogFilters() {
        assertEquals(0, filter.getSeverity());
        assertEquals(new ArrayList<Integer>(), filter.getCategory());
    }

    @Test
    public void testAddCategoryNotContain() {
        Integer in = new Integer(1);
        filter.addCategory(new Integer(1));
        assertTrue(filter.getCategory().contains(in));
    }

    @Test
    public void testAddCategoryAlreadyContains() {
        Integer in = new Integer(1);
        filter.addCategory(new Integer(1));
        assertTrue(filter.getCategory().contains(in));
        filter.addCategory(in);
        assertTrue(filter.getCategory().contains(in));
    }

    @Test
    public void testRemoveCategory() {
        Integer in = new Integer(1);
        filter.addCategory(in);
        assertTrue(filter.getCategory().contains(in));
        filter.removeCategory(in);
        assertFalse(filter.getCategory().contains(new Integer(1)));
    }

    @Test
    public void testSetSeverity() {
        filter.setSeverity(5);
        assertEquals(5, filter.getSeverity());
    }

}
