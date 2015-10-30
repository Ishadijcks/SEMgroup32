package test.wall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import game.wall.PlayerWall;
import game.helperobjects.Coordinates;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the playerWall class.
 * 
 * @author Isha
 *
 */
public class PlayerWallTest {

    private PlayerWall wall;

    /**
     * Sets up initial variables used in the tests.
     */
    @Before
    public void init() {
        wall = new PlayerWall(new Coordinates(10, 0), 10);
    }

    /**
     * Test if the playerWall is created correctly.
     */
    @Test
    public void testPlayerWall() {
        assertEquals(10, wall.getxCoord());
        assertEquals(0, wall.getyCoord());
        assertEquals(Color.GREEN, wall.getColor());
    }

    /**
     * Tests if the collision is handled correctly.
     */
    @Test
    public void testExpectBubbleCollision() {
        assertFalse(wall.expectBubbleCollision(100, 5, 1));
    }

}
