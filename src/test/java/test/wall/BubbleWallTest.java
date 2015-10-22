package test.wall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.wall.BubbleWall;
import game.wall.NoMoveBubbleWall;
import helperobjects.Coordinates;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import settings.ScreenSettings;

public class BubbleWallTest {

    private NoMoveBubbleWall wall;

    @Before
    public void init() {
        wall = new NoMoveBubbleWall(new Coordinates(10, 0), ScreenSettings.getLevelHeight(), 10);
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
        assertTrue(wall.expectBubbleCollision(10, 5, 500));
        assertFalse(wall.expectBubbleCollision(100, 5, 1));
    }

    @Test
    public void testExpectPlayerCollision() {
        assertFalse(wall.expectPlayerCollision(100, 5, false));
    }

}
