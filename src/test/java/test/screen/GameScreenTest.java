package test.screen;

import static org.junit.Assert.assertFalse;
import game.screens.GameScreen;

import org.junit.Test;
/**
 * Tests if the game screen is created correctly.
 * @author Isha
 *
 */
public class GameScreenTest {

    /**
     * Tests if the game screen opens correctly.
     */
    @Test
    public void testGameScreenStart() {
        GameScreen screen = new GameScreen();
        screen.startGame();
        assertFalse(screen == null);
    }

    /**
     * Tests if the game screen closes correctly.
     */
    @Test
    public void testGameScreenClose() {
        GameScreen screen = new GameScreen();
        screen.dispose();
        assertFalse(screen == null);
    }

}
