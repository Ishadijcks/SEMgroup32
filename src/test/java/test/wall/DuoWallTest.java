package test.wall;


import static org.junit.Assert.*;
import game.wall.DuoWall;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class DuoWallTest {
	
	private DuoWall w;
	
	@Before
	public void init() {
		w = new DuoWall(10);
	}

	@Test
	public void testDuoWall() {
		assertEquals(10, w.getxCoord());
		assertEquals(0, w.getyCoord());
		assertEquals(Color.BLUE, w.getColor());
	}

}
