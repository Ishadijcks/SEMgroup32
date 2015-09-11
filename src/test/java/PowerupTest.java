import static org.junit.Assert.*;
import game.Powerup;
import game.Settings;

import org.junit.Before;
import org.junit.Test;

public class PowerupTest {

	public int x;
	public int y;
	public Powerup powerup;
	public int framesLeft;
    int height = Settings.getPowerupHeight();
    int width = Settings.getPowerupWidth();

	@Before
	public void init() {
		x = 3;
		y = 5;
		String name = "speed";

		powerup = new Powerup(name, x, y);
	}

	@Test
	public void testEquals() {
		Powerup powerup1 = new Powerup("name", 2, 3);
		Powerup powerup2 = new Powerup("name", 2, 3);
		Powerup powerup3 = new Powerup("name", 2, 4);
		assertTrue(powerup1.equals(powerup2));
		assertFalse(powerup1.equals(powerup3));

	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecreaseFramesLeft() {
			int framesLeft = 10;
	powerup.decreaseFramesLeft();
	assertEquals(framesLeft, 9);
	}
	
	@Test
	public void testIsActive() {
		assertTrue(powerup.isActive());
	}

	@Test
	public void testGetHeight() {
		int height2 = 10;
		assertEquals(height,height2);
		
	}

	@Test
	public void testGetWidth() {
		int width2 = 15;
		assertEquals(width, width2);
	}

	@Test
	public void testGetFramesLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

}
