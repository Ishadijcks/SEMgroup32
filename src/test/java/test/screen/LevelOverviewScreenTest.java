package test.screen;

import static org.junit.Assert.assertFalse;
import game.screens.LevelOverviewScreen;

import org.junit.Test;

public class LevelOverviewScreenTest {

    @Test
    public void testLevelOverviewScreen() {
        LevelOverviewScreen overview = new LevelOverviewScreen();
        assertFalse(overview == null);
    }

}
