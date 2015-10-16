package test.screen;

import static org.junit.Assert.assertFalse;
import game.NormalGame;
import game.SurvivalGame;
import game.screens.PauseScreen;

import org.junit.Test;

public class PauseScreenTest {

    @Test
    public void testPauseScreenNormalGame() {
        NormalGame normal = new NormalGame();
        PauseScreen pause = new PauseScreen("Player", normal);
        assertFalse(pause == null);
    }
    
    @Test
    public void testPauseScreenSurvivalGame() {
        SurvivalGame survival = new SurvivalGame();
        PauseScreen pause = new PauseScreen("Player", survival);
        assertFalse(pause == null);
    }

}
