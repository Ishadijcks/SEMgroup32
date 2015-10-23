package test.screen;

import static org.junit.Assert.assertFalse;
import game.screens.StartScreen;

import org.junit.Test;
/**
 * Tests if the start screen is created correctly.
 * @author Isha
 *
 */
public class StartScreenTest {

    /**
     * Tests if the start screen is opened correctly.
     */
    @Test
    public void testStartScreen() {
        StartScreen sc = new StartScreen();
        sc.addStopButton();
        assertFalse(sc == null);
    }

}
