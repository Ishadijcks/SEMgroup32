package test.wall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.wall.NoMoveBubbleWall;
import helperobjects.Coordinates;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import settings.ScreenSettings;

/**
 * Test class for the bubblWwall class.
 * 
 * @author Isha
 *
 */
public class BubbleWallTest {

    private NoMoveBubbleWall wall;

    /**
     * Sets up initial variables used in the tests.
     */
    @Before
    public void init() {
        wall = new NoMoveBubbleWall(new Coordinates(10, 0),
                ScreenSettings.getLevelHeight(), 10);
    }

    /**
     * Test if the bubbleWall is created correctly.
     */
    @Test
    public void testBubbleWall() {
        assertEquals(10, wall.getxCoord());
        assertEquals(0, wall.getyCoord());
        assertEquals(Color.RED, wall.getColor());
    }

    /**
     * Test if the bounced on is handled correctly.
     */
    @Test
    public void testBouncedOn() {
        wall.bouncedOn();
        assertFalse(wall.isActive());
    }

    /**
     * Test if the collision between wall and bubble is handled correctly.
     */
    @Test
    public void testExpectBubbleCollision() {
        assertTrue(wall.expectBubbleCollision(10, 5, 500));
        assertFalse(wall.expectBubbleCollision(100, 5, 1));
    }

    /**
     * Test if the collision between wall and player is handled correctly.
     */
    @Test
    public void testExpectPlayerCollision() {
        assertFalse(wall.expectPlayerCollision(100, 5, false));
    }

}
