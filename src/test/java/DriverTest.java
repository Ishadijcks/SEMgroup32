import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.Driver;
import game.NormalDriver;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {

    private NormalDriver driver;

    @Before
    public void init() {
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
        assertFalse(Driver.game.inProgress());
        driver.startGame("Isha");
        assertTrue(Driver.game.inProgress());
    }
    
    @Test
    public void testSetTotalFrames() {
    	assertTrue(driver.getTotalFrames() != 5);
    	driver.setTotalFrames(5);
    	assertTrue(driver.getTotalFrames() == 5);
    }
}
