package test.powerups;

import static org.junit.Assert.*;
import game.powerups.Powerup;
import game.powerups.PowerupFactory;

import org.junit.Before;
import org.junit.Test;

public class PowerupFactoryTest {
	
	PowerupFactory pFac;
	
	@Before
	public void inti() {
		pFac = new PowerupFactory();
	}

	@Test
	public void testCreateRandomPowerup() {
		assertTrue(pFac.createRandomPowerup() instanceof Powerup);
	}

}
