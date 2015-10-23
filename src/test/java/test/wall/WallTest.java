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


/**
 * Test class for the wall class.
 * @author Isha
 *
 */
public class WallTest {

    private Wall wall;
    private Wall otherWall;

    /**
     * Sets up initial variables used in the tests.
     */
    @Before
    public void init() {
        wall = new DuoWall(new Coordinates(10, 0), 500, 10);
        otherWall = new DuoWall(new Coordinates(10, 0), 500, 10);
    }

    /**
     * Tests if the wall was created correctly.
     */
    @Test
    public void testWall() {
        assertEquals(10, wall.getxCoord());
        assertEquals(0, wall.getyCoord());
        assertEquals(Color.blue, wall.getColor());
    }

    /**
     * Tests if the wall was created correctly.
     */
    @Test
    public void testEquals() {
        assertTrue(wall.equals(otherWall));
    }

    /**
     * Tests if the height was set correctly.
     */
    @Test
    public void testGetHeight() {
        assertEquals(500, wall.getHeight());
    }
    /**
     * Tests if the width was set correctly.
     */
    @Test
    public void testGetWidth() {
        assertEquals(10, wall.getWidth());
    }
    /**
     * Tests if the color was set correctly.
     */
    @Test
    public void testGetColor() {
        assertEquals(Color.blue, wall.getColor());
    }

    /**
     * Tests if the height can be set correctly.
     */
    @Test
    public void testSetHeight() {
        wall.setHeight(500);
        assertEquals(500, wall.getHeight());
    }

    /**
     * Tests if the width can be set correctly.
     */
    @Test
    public void testSetWidth() {
        wall.setWidth(500);
        assertEquals(500, wall.getWidth());
    }

    /**
     * Tests if the xCoord can be set correctly.
     */
    @Test
    public void testSetxCoord() {
        wall.setxCoord(55);
        assertEquals(55, wall.getxCoord());
    }

    /**
     * Tests if the yCoord can be set correctly.
     */
    @Test
    public void testSetyCoord() {
        wall.setyCoord(55);
        assertEquals(55, wall.getyCoord());
    }

    /**
     * Tests if the color can be set correctly.
     */
    @Test
    public void testSetColor() {
        wall.setColor(Color.pink);
        assertEquals(Color.pink, wall.getColor());
    }

    /**
     * Tests if the wall is active.
     */
    @Test
    public void testIsActive() {
        assertTrue(wall.isActive());
    }

    /**
     * Tests if the isActive can be set correctly.
     */
    @Test
    public void testSetActive() {
        wall.setActive(false);
        assertFalse(wall.isActive());
    }

}
