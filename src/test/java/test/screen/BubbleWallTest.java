package test.screen;

import static org.junit.Assert.*;
import game.wall.BubbleWall;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import settings.screenSettings;

public class BubbleWallTest {
	
	private BubbleWall w;
	
	@Before
	public void init() {
		w = new BubbleWall(10, 0, screenSettings.getLevelHeight(), 10);
	}

	@Test
	public void testBubbleWall() {
		assertEquals(10, w.getxCoord());
		assertEquals(0, w.getyCoord());
		assertEquals(Color.RED, w.getColor());
	}

}
