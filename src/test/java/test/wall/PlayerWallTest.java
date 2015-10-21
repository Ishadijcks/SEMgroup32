package test.wall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import game.wall.PlayerWall;
import helperobjects.Coordinates;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import settings.screenSettings;

public class PlayerWallTest {
<<<<<<< HEAD
	
	private PlayerWall wall;
	
	@Before
	public void init(){
		wall = new PlayerWall(new Coordinates(10, 0), screenSettings.getLevelHeight(), 10);
	}

	@Test
	public void testPlayerWall() {
		assertEquals(10, wall.getxCoord());
		assertEquals(0, wall.getyCoord());
		assertEquals(Color.GREEN, wall.getColor());
	}
	
	@Test
=======

    private PlayerWall wall;

    @Before
    public void init() {
        wall = new PlayerWall(10);
    }

    @Test
    public void testPlayerWall() {
        assertEquals(10, wall.getxCoord());
        assertEquals(0, wall.getyCoord());
        assertEquals(Color.GREEN, wall.getColor());
    }

    @Test
>>>>>>> 2ba4d40c50b5dc0078e6bb71f45eea0d5fa315ff
    public void testExpectPlayerCollision() {
        assertFalse(wall.expectPlayerCollision(10, true));
    }

    @Test
    public void tesexpectBubbleCollision() {
        assertFalse(wall.expectBubbleCollision(100, 1));
    }

}
