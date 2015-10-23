package test.screen;

import static org.junit.Assert.assertFalse;
import game.NormalGame;
import game.SurvivalGame;
import game.screens.PauseScreen;

import org.junit.Test;

/**
 * Tests if the pause screen is created correctly.
 * 
 * @author Isha
 *
 */
public class PauseScreenTest {

    /**
     * Tests if the pause screen is created correctly for a normal game.
     */
    @Test
    public void testPauseScreenNormalGame() {
        NormalGame normal = new NormalGame();
        PauseScreen pause = new PauseScreen("Player", normal);
        assertFalse(pause == null);
    }

    /**
     * Tests if the pause screen is created correctly for a survival game.
     */
    @Test
    public void testPauseScreenSurvivalGame() {
        SurvivalGame survival = new SurvivalGame();
        PauseScreen pause = new PauseScreen("Player", survival);
        assertFalse(pause == null);
    }

}
