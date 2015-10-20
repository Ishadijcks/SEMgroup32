package test.wall;


import static org.junit.Assert.*;
import game.wall.DuoWall;
import helperobjects.Coordinates;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import settings.screenSettings;

public class DuoWallTest {
	
	private DuoWall wall;
	
	@Before
	public void init() {
		wall = new DuoWall(new Coordinates(10, 0), screenSettings.getLevelHeight(), 10);
	}

	@Test
	public void testDuoWall() {
		assertEquals(10, wall.getxCoord());
		assertEquals(0, wall.getyCoord());
		assertEquals(Color.BLUE, wall.getColor());
	}
	
	@Test
    public void testexpectPlayerCollision() {
        assertFalse(wall.expectPlayerCollision(10, true));
    }
	
	@Test
    public void tesexpectBubbleCollision() {
        assertTrue(wall.expectBubbleCollision(10, 500));
        assertFalse(wall.expectBubbleCollision(100, 1));
    }

}
