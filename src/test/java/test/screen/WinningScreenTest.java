package test.screen;

import static org.junit.Assert.assertFalse;
import game.screens.WinningScreen;

import org.junit.Test;

/**
 * Tests if the winning screen is created correctly.
 * @author Isha
 *
 */
public class WinningScreenTest {

    /**
     * Tests if the winning screen is opened correctly for a normal game.
     */
    @Test
    public void testLosingScreenNormalDriver() {
        WinningScreen ls = new WinningScreen();
        assertFalse(ls == null);
    }

}
