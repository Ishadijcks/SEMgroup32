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

<<<<<<< HEAD
import settings.screenSettings;
import settings.wallSettings;


public class WallTest {
	
	private Wall wall;
	private Wall otherWall;
	
	@Before
	public void init() {
		wall = new DuoWall(new Coordinates(10, 0), screenSettings.getLevelHeight(), 10);
		otherWall = new DuoWall(new Coordinates(1, 0), screenSettings.getLevelHeight(), 10);
	}

	@Test
	public void testWall() {
		assertEquals(10, wall.getxCoord());
		assertEquals(0, wall.getyCoord());
		assertEquals(Color.blue, wall.getColor());
	}
=======
import settings.WallSettings;

public class WallTest {

    private Wall wall;
    private Wall otherWall;

    @Before
    public void init() {
        wall = new DuoWall(10);
        otherWall = new DuoWall(10);
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
>>>>>>> 2ba4d40c50b5dc0078e6bb71f45eea0d5fa315ff

    @Test
    public void testGetHeight() {
        assertEquals(WallSettings.getWallHeight(), wall.getHeight());
    }

    @Test
    public void testGetWidth() {
        assertEquals(WallSettings.getWallWidth(), wall.getWidth());
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
