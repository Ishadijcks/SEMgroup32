package test.wall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.wall.DuoWall;
import helperobjects.Coordinates;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import settings.screenSettings;

public class DuoWallTest {
<<<<<<< HEAD
	
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
=======

    private DuoWall wall;

    @Before
    public void init() {
        wall = new DuoWall(10);
    }

    @Test
    public void testDuoWall() {
        assertEquals(10, wall.getxCoord());
        assertEquals(0, wall.getyCoord());
        assertEquals(Color.BLUE, wall.getColor());
    }

    @Test
>>>>>>> 2ba4d40c50b5dc0078e6bb71f45eea0d5fa315ff
    public void testexpectPlayerCollision() {
        assertFalse(wall.expectPlayerCollision(10, true));
    }

    @Test
    public void tesexpectBubbleCollision() {
        assertTrue(wall.expectBubbleCollision(10, 500));
        assertFalse(wall.expectBubbleCollision(100, 1));
    }

}
