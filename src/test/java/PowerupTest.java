import static org.junit.Assert.*;

import java.net.URL;

import javax.swing.ImageIcon;

import game.Driver;
import game.Powerup;
import game.Settings;
import game.StartScreen;

import org.junit.Before;
import org.junit.Test;

public class PowerupTest {

	public int x;
	public int y;
	public Powerup powerup;
	int framesLeft=10*Settings.getFps();
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
		int framesLeft2= 1200;
		assertEquals(framesLeft,framesLeft2);
	}

	@Test
	public void testGetName() {
		Powerup powerup2 = new Powerup("speed", x, y);
		assertEquals(powerup, powerup2);
		
	}
	
	@Test
	public void testGetImageIconSpeed() {
		Powerup pow = new Powerup("speed", 100, 100);
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
		ImageIcon expected = new ImageIcon(imageLocation + "main/Images/Powerups/puspeed.png", "speed");
		assertTrue(pow.getImageIcon().getDescription().equals(expected.getDescription()));
	}
	
	@Test
	public void testGetImageIconLife(){
		Powerup pow = new Powerup("life", 100, 100);
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
		ImageIcon expected = new ImageIcon(imageLocation + "main/Images/Powerups/pulife.png", "life");
		assertTrue(pow.getImageIcon().getDescription().equals(expected.getDescription()));
	}
	
	@Test
	public void testGetImageIconIce(){
		Powerup pow = new Powerup("ice", 100, 100);
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
		ImageIcon expected = new ImageIcon(imageLocation + "main/Images/Powerups/puice.png", "ice");
		assertTrue(pow.getImageIcon().getDescription().equals(expected.getDescription()));
	}
	
	@Test
	public void testGetImageIconNull(){
		Powerup pow = new Powerup("randomstring", 100, 100);
		assertNull(pow.getImageIcon());
	}
	
	@Test
	public void testMove(){
		Driver driver = new Driver();
		driver.initGame();
		driver.setupGame();
		Powerup pow = new Powerup("ice", 100, 100);
		int deltaY = Settings.getPowerupSpeed();
		int initY = 100;
		pow.move();
		assertEquals(initY + deltaY, pow.getY());
	}
	
	@Test
	public void testSamePowerupSamecoords(){
		Powerup pow = new Powerup("ice", 100, 100);
		assertTrue(pow.samePowerup(new Powerup("ice", 100,100)));
		assertFalse(pow.samePowerup(new Powerup("nothing", 100, 100)));
	}
	
	@Test
	public void testSamePowerupDiffcoords(){
		Powerup pow = new Powerup("ice", 100, 100);
		assertTrue(pow.samePowerup(new Powerup("ice", 10,10)));
		assertFalse(pow.samePowerup(new Powerup("nothing", 10, 10)));
	}
	
	@Test
	public void testDecreaseFramesLeft(){
		Powerup pow = new Powerup("ice", 100, 100);
		int initFrames = pow.getFramesLeft();
		pow.decreaseFramesLeft();
		assertEquals(initFrames - 1, pow.getFramesLeft());
	}
	
	@Test
	public void testResetFramesLeft(){
		Powerup pow = new Powerup("ice", 100, 100);
		int initFrames = pow.getFramesLeft();
		pow.decreaseFramesLeft();
		assertNotEquals(initFrames, pow.getFramesLeft());
		pow.resetFramesLeft();
		assertEquals(initFrames, pow.getFramesLeft());
	}
	
	@Test
	public void testSetFramesLeft(){
		Powerup pow = new Powerup("ice", 100, 100);
		pow.setFramesLeft(5);
		assertEquals(5, pow.getFramesLeft());
	}

}
