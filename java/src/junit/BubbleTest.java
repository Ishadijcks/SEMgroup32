package junit;
import static org.junit.Assert.*;

import java.awt.Color;

import game.Bubble;

import org.junit.Test;


public class BubbleTest {

	@Test
	public void testBubbleDefault() {
		int diameter = 10000;
		double x = 2;
		double y = 2;
		
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
		double x = 2;
		double y = 2;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.BLUE);
	}
	@Test
	public void testBubble16() {
		int diameter = 16;
		double x = 2;
		double y = 2;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.BLACK);
	}
	@Test
	public void testBubble32() {
		int diameter = 32;
		double x = 2;
		double y = 2;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.GREEN);
	}
	@Test
	public void testBubble64() {
		int diameter = 64;
		double x = 2;
		double y = 2;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.CYAN);
	}
	@Test
	public void testBubble128() {
		int diameter = 128;
		double x = 2;
		double y = 2;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.PINK);
	}
	@Test
	public void testBubbleNegative() {
		int diameter = -8;
		double x = 2;
		double y = 2;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertEquals(bub.getColor(), Color.MAGENTA);
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testBounceH() {
		int diameter = 128;
		double x = 2;
		double y = 2;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertTrue(bub.isDirectionH());
		bub.bounceH();
		assertFalse(bub.isDirectionH());
	}

	@Test
	public void testBounceV() {
		int diameter = 128;
		double x = 2;
		double y = 2;
		
		Bubble bub = new Bubble(diameter, x, y, true, true);
		
		assertTrue(bub.isDirectionV());
		bub.bounceV();
		assertFalse(bub.isDirectionV());
	}

}
