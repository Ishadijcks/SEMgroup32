package test.wall;

import static org.junit.Assert.*;
import game.wall.PlayerWall;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class PlayerWallTest {
	
	private PlayerWall w;
	
	@Before
	public void init(){
		w = new PlayerWall(10);
	}

	@Test
	public void testPlayerWall() {
		assertEquals(10, w.getxCoord());
		assertEquals(0, w.getyCoord());
		assertEquals(Color.GREEN, w.getColor());
	}

}
