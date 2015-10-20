package test.wall;

import static org.junit.Assert.*;
import game.wall.PlayerWall;
import helperobjects.Coordinates;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import settings.screenSettings;

public class PlayerWallTest {
	
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
    public void testExpectPlayerCollision() {
        assertFalse(wall.expectPlayerCollision(10, true));
    }
    
    @Test
    public void tesexpectBubbleCollision() {
        assertFalse(wall.expectBubbleCollision(100, 1));
    }

}
