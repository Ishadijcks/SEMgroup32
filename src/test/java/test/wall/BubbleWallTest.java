package test.wall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.wall.BubbleWall;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import settings.screenSettings;

public class BubbleWallTest {

    private BubbleWall wall;

    @Before
    public void init() {
        wall = new BubbleWall(10, 0, screenSettings.getLevelHeight(), 10);
    }

    @Test
    public void testBubbleWall() {
        assertEquals(10, wall.getxCoord());
        assertEquals(0, wall.getyCoord());
        assertEquals(Color.RED, wall.getColor());
    }

    @Test
    public void testBouncedOn() {
        wall.bouncedOn();
        assertFalse(wall.isActive());
    }

    @Test
    public void testExpectBubbleCollision() {
        assertTrue(wall.expectBubbleCollision(10, 500));
        assertFalse(wall.expectBubbleCollision(100, 1));
    }

    @Test
    public void testExpectPlayerCollision() {
        assertFalse(wall.expectPlayerCollision(100, false));
    }

}
