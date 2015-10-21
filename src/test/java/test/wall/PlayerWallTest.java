package test.wall;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import game.wall.PlayerWall;
import helperobjects.Coordinates;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import settings.ScreenSettings;


public class PlayerWallTest {
	
	private PlayerWall wall;
	
	@Before
	public void init(){
		wall = new PlayerWall(new Coordinates(10, 0), 10);
	}

	@Test
	public void testPlayerWall() {
		assertEquals(10, wall.getxCoord());
		assertEquals(0, wall.getyCoord());
		assertEquals(Color.GREEN, wall.getColor());
	}

    @Test
    public void tesexpectBubbleCollision() {
        assertFalse(wall.expectBubbleCollision(100, 5, 1));
    }

}
