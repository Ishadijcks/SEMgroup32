package test.screen;

import static org.junit.Assert.assertFalse;
import game.screens.GameScreen;

import org.junit.Test;

public class GameScreenTest {

    @Test
    public void testGameScreenStart() {
        GameScreen screen = new GameScreen();
        screen.startGame();
        assertFalse(screen == null);
    }

    @Test
    public void testGameScreenClose() {
        GameScreen screen = new GameScreen();
        screen.dispose();
        assertFalse(screen == null);
    }

}
