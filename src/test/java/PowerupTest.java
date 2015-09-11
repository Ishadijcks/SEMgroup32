
import static org.junit.Assert.*;

import org.junit.Test;


public class PowerupTest {

	public int x;
	public int y;
	public Powerup powerup;
	
	@Before
	public void init() {
		x = 3;
		y = 5;	
		String name = name;
			
		powerup = new Powerup(name, x, y);		
	}
	
	@Test
	public void testEquals(){
		Powerup powerup1 = new Powerup("name", 2, 3);
		Powerup powerup2 = new Powerup("name", 2, 3);
		Powerup powerup3 = new Powerup("name", 2, 4);
		assertTrue(powerup1.equals(powerup2));
		assertFalse(powerup1.equals(powerup3));
		
	}
	
	@Test
	public void testPowerup() {
		assertTrue(powerup != null);
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecreaseFramesLeft() {
		for(int framesLeft = 1; framesLeft < 10; framesLeft++){
			decreaseFramesLeft();
			assertTrue(framesLeft.equals(framesLeft-1));
		}		
		
	}

	@Test
	public void testIsActive() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWidth() {
		fail("Not yet implemented");
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
