

import static org.junit.Assert.*;
import game.NormalDriver;
import game.MathFunctions;
import game.log.LogObject;
import game.log.Logger;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {
	
	private NormalDriver driver;
	
	@Before
	public void init(){
		driver = new NormalDriver(null);
		driver.initGame();
		driver.setupGame();
	}

	@Test
	public void testPaintGraphics() {
	}

	@Test
	public void testRandomInt() {
		assertEquals(1, MathFunctions.randomInt(1, 1));
	}


	@Test
	public void testStartGame() {
		assertFalse(driver.game.inProgress());
		driver.startGame("Isha");
		assertTrue(driver.game.inProgress());
	}

	@Test
	public void testCheckGameWon() {
		assertFalse(driver.checkGameWon());
		driver.game.setCurrentLevelInt(driver.game.getLevelList().size()-1);
		assertTrue(driver.checkGameWon());
	}

	@Test
	public void testCheckGameLost() {
		assertFalse(driver.checkGameLost());
		driver.game.setLives(0);
		driver.game.toggleProgress();
		assertTrue(driver.checkGameLost());
	}

}
