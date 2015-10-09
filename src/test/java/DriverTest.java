

import static org.junit.Assert.*;

import java.util.Random;

import game.NormalDriver;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {
	
	private NormalDriver driver;
	
	@Before
	public void init(){
		driver = new NormalDriver();
		driver.setupGame();
		driver.initDriver();
	}

	@Test
	public void testPaintGraphics() {
	}

	@Test
	public void testRandomInt() {
	    Random rand = new Random();
	    int randomInt = rand.nextInt((1 - 1) + 1) + 1;
		assertEquals(1, randomInt);
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
