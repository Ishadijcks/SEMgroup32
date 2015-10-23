package test.wall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.wall.DuoWall;
import game.wall.Wall;
import helperobjects.Coordinates;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;



public class WallTest {

    private Wall wall;
    private Wall otherWall;

    @Before
    public void init() {
        wall = new DuoWall(new Coordinates(10, 0), 500, 10);
        otherWall = new DuoWall(new Coordinates(10, 0), 500, 10);
    }

    @Test
    public void testWall() {
        assertEquals(10, wall.getxCoord());
        assertEquals(0, wall.getyCoord());
        assertEquals(Color.blue, wall.getColor());
    }

    @Test
    public void testEquals() {
        assertTrue(wall.equals(otherWall));
    }

    @Test
    public void testGetHeight() {
        assertEquals(500, wall.getHeight());
    }

    @Test
    public void testGetWidth() {
        assertEquals(10, wall.getWidth());
    }

    @Test
    public void testGetColor() {
        assertEquals(Color.blue, wall.getColor());
    }

    @Test
    public void testSetHeight() {
        wall.setHeight(500);
        assertEquals(500, wall.getHeight());
    }

    @Test
    public void testSetWidth() {
        wall.setWidth(500);
        assertEquals(500, wall.getWidth());
    }

    @Test
    public void testSetxCoord() {
        wall.setxCoord(55);
        assertEquals(55, wall.getxCoord());
    }

    @Test
    public void testSetyCoord() {
        wall.setyCoord(55);
        assertEquals(55, wall.getyCoord());
    }

    @Test
    public void testSetColor() {
        wall.setColor(Color.pink);
        assertEquals(Color.pink, wall.getColor());
    }

    @Test
    public void testIsActive() {
        assertTrue(wall.isActive());
    }

    @Test
    public void testSetActive() {
        wall.setActive(false);
        assertFalse(wall.isActive());
    }

}
