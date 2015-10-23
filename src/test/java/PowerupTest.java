import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.NormalDriver;
import game.powerups.IcePowerup;
import game.powerups.LifePowerup;
import game.powerups.Powerup;
import game.powerups.SpeedPowerup;
import game.screens.StartScreen;

import java.net.URL;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

public class PowerupTest {

    public int x;
    public int y;
    public Powerup powerup;
    int height = 10;
    int width = 15;

    @Before
    public void init() {
        x = 3;
        y = 5;
        powerup = new SpeedPowerup(x, y);
    }

    @Test
    public void testEquals() {
        Powerup powerup1 = new SpeedPowerup(2, 3);
        Powerup powerup2 = new SpeedPowerup(2, 3);
        Powerup powerup3 = new SpeedPowerup(2, 4);
        assertTrue(powerup1.equals(powerup2));
        assertFalse(powerup1.equals(powerup3));

    }

    @Test
    public void testGetHeight() {
        int height2 = 10;
        assertEquals(height, height2);

    }

    @Test
    public void testGetWidth() {
        int width2 = 15;
        assertEquals(width, width2);
    }

    @Test
    public void testGetName() {
        Powerup powerup2 = new SpeedPowerup(x, y);
        assertEquals(powerup, powerup2);

    }

    @Test
    public void testGetImageIconSpeed() {
        Powerup pow = new SpeedPowerup(100, 100);
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        ImageIcon expected = new ImageIcon(imageLocation
                + "main/Images/Powerups/puspeed.png", "speed");
        assertTrue(pow.getImageIcon().getDescription()
                .equals(expected.getDescription()));
    }

    @Test
    public void testGetImageIconLife() {
        Powerup pow = new LifePowerup(100, 100);
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        ImageIcon expected = new ImageIcon(imageLocation
                + "main/Images/Powerups/pulife.png", "life");
        assertTrue(pow.getImageIcon().getDescription()
                .equals(expected.getDescription()));
    }

    @Test
    public void testGetImageIconIce() {
        Powerup pow = new IcePowerup(100, 100);
        URL location = StartScreen.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String imageLocation = location.getFile();
        imageLocation = imageLocation.replace("%20", " ");
        ImageIcon expected = new ImageIcon(imageLocation
                + "main/Images/Powerups/puice.png", "ice");
        assertTrue(pow.getImageIcon().getDescription()
                .equals(expected.getDescription()));
    }

    @Test
    public void testMoveNormalMode() {
        NormalDriver driver = new NormalDriver();
        driver.setupGame();
        driver.initDriver();
        Powerup pow = new IcePowerup(100, 100);
        int deltaY = pow.getPowerupSpeed();
        int initY = 100;
        pow.move();
        assertEquals(initY + deltaY, pow.getY());
    }

    @Test
    public void testMoveSurvivalMode() {
        Powerup pow = new IcePowerup(100, 100);
        int deltaY = pow.getPowerupSpeed();
        int initY = 100;
        pow.move();
        assertEquals(initY + deltaY, pow.getY());
    }

}
