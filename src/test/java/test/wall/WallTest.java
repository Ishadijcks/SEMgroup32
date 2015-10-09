package test.wall;

import static org.junit.Assert.*;
import game.Settings;
import game.wall.DuoWall;
import game.wall.Wall;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;


public class WallTest {
	
	private Wall w;
	
	@Before
	public void init() {
		w = new DuoWall(10);
	}

	@Test
	public void testWall() {
		assertEquals(10, w.getxCoord());
		assertEquals(0, w.getyCoord());
		assertEquals(Color.blue, w.getColor());
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
