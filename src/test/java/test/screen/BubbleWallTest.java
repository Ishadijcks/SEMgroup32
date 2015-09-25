package test.screen;

import static org.junit.Assert.*;
import game.wall.BubbleWall;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class BubbleWallTest {
	
	private BubbleWall w;
	
	@Before
	public void init() {
		w = new BubbleWall(10,11);
	}

	@Test
	public void testBubbleWall() {
		assertEquals(10, w.getX());
		assertEquals(11, w.getY());
		assertEquals(Color.RED, w.getColor());
	}

}
