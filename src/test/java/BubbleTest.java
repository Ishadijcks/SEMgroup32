import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Color;

import game.Bubble;

import org.junit.Before;
import org.junit.Test;


public class BubbleTest {
	
	public double x;
	public double y;
	public Bubble bubble;
	
	@Before
	public void init() {
		x = 2;
		y = 2;
		int diameter = 8;
		
		bubble = new Bubble(diameter, x, y, true, true);
	}

	@Test
	public void testBubbleDefault() {
		int diameter = 10000;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getDiameter(), diameter);
		assertEquals(bub.getX(), (int) x);
		assertEquals(bub.getY(), (int) y);
		assertEquals(bub.getColor(), Color.MAGENTA);
		assertTrue(bub.isDirectionH());
		assertTrue(bub.isDirectionV());		
	}
	
	@Test
	public void testBubble8() {
		int diameter = 8;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.BLUE);
	}
	@Test
	public void testBubble16() {
		int diameter = 16;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.BLACK);
	}
	@Test
	public void testBubble32() {
		int diameter = 32;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.GREEN);
	}
	@Test
	public void testBubble64() {
		int diameter = 64;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.CYAN);
	}
	@Test
	public void testBubble128() {
		int diameter = 128;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.PINK);
	}
	@Test
	public void testBubbleNegative() {
		int diameter = -8;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.MAGENTA);
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testBounceH() {		
		assertTrue(bubble.isDirectionH());
		bubble.bounceH();
		assertFalse(bubble.isDirectionH());
	}

	@Test
	public void testBounceV() {
		assertTrue(bubble.isDirectionV());
		bubble.bounceV();
		assertFalse(bubble.isDirectionV());
	}

}
