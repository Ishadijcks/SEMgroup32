package test.wall;

import static org.junit.Assert.*;
import game.Settings;
import game.wall.Wall;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;


public class WallTest {
	
	private Wall w;
	
	@Before
	public void init() {
		w = new Wall(10,Color.PINK);
	}

	@Test
	public void testWall() {
		assertEquals(10, w.getxCoord());
		assertEquals(0, w.getyCoord());
		assertEquals(Color.PINK, w.getColor());
	}

	@Test
	public void testGetHeight() {
		assertEquals(Settings.getWallHeight(), w.getHeight());
	}

	@Test
	public void testGetWidth() {
		assertEquals(Settings.getWallWidth(), w.getWidth());
	}

}
