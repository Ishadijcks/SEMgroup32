package test.logger;


import static org.junit.Assert.*;
import game.log.LogObject;

import org.junit.Before;
import org.junit.Test;

public class LogObjectTest {
	
	private LogObject lo;
	
	@Before
	public void init(){
		lo = new LogObject("Test Message", 1, 2);
	}

	@Test
	public void testLogObject() {
		assertEquals("Test Message", lo.getMessage());
		assertEquals(2, lo.getSeverity());
		assertEquals(1, lo.getCategory());
	}

	@Test
	public void testToString() {
		assertEquals("[EXCEPTION] [Player] Test Message", lo.toString());
	}
	
	@Test
	public void testToStringOutOfBounds(){
		LogObject lo1 = new LogObject("Test Message", -10000, 1);
		assertEquals("[EXCEPTION] [Player] Test Message", lo.toString());
	}

	@Test
	public void testToStringShort() {
		assertEquals("[Player] Test Message", lo.toStringShort());
	}
	
	@Test
	public void testToStringShortOutOfBounds(){
		LogObject lo1 = new LogObject("Test Message", -10000, 1);
		assertEquals("[Player] Test Message", lo.toStringShort());
	}

	@Test
	public void testEqualsObject() {
		LogObject lo1 = new LogObject("Test Message", 2, 2);
		LogObject lo2 = new LogObject("Test Mesage", 1, 2);
		LogObject lo3 = new LogObject("Test Message", 1, 1);
		LogObject lo4 = new LogObject("Test Message", 1, 2);
		
		assertFalse(lo.equals(lo1));
		assertFalse(lo.equals(lo2));
		assertFalse(lo.equals(lo3));
		assertTrue(lo.equals(lo4));
	}

}
