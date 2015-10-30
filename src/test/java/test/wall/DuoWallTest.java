package test.wall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.wall.DuoWall;
import game.helperobjects.Coordinates;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;


/**
 * Test class for the duoWall class.
 * 
 * @author Isha
 *
 */
public class DuoWallTest {
	
	private DuoWall wall;
	
	@Before
	public void init() {
		wall = new DuoWall(new Coordinates(10, 0), 500, 10);
	}

    /**
     * Test if the duoWall is created correctly.
     */
    @Test
    public void testDuoWall() {
        assertEquals(10, wall.getxCoord());
        assertEquals(0, wall.getyCoord());
        assertEquals(Color.BLUE, wall.getColor());
    }

    /**
     * Test if the collision between wall and player is handled correctly.
     */
    @Test
    public void testexpectPlayerCollision() {
        assertFalse(wall.expectPlayerCollision(10, 5, true));
    }

    /**
     * Test if the collision between wall and bubble is handled correctly.
     */
    @Test
    public void tesexpectBubbleCollision() {
        assertTrue(wall.expectBubbleCollision(10, 5, 500));
        assertFalse(wall.expectBubbleCollision(100, 5, 1));
    }

}
