package test.screen;

import static org.junit.Assert.assertFalse;
import game.screens.LevelOverviewScreen;

import org.junit.Test;
/**
 * Tests if the level overview screen is created correctly.
 * @author Isha
 *
 */
public class LevelOverviewScreenTest {

    /**
     * Tests if the level overview screen opens correctly.
     */
    @Test
    public void testLevelOverviewScreen() {
        LevelOverviewScreen overview = new LevelOverviewScreen();
        assertFalse(overview == null);
    }

}
