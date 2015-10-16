

import static org.junit.Assert.*;
import game.MainRunner;
import game.SurvivalGame;

import org.junit.Before;
import org.junit.Test;

public class SurvivalGameTest {
    SurvivalGame game;
    @Before
    public void init() {
        game = new SurvivalGame();
    }

	@Test
	public void testSurvivalGame() {
		assertTrue(game.getLives() == 1);
	}

    @Test
    public void testSurvivalGameEnd() {
        game.gameStart();
        game.endGame();
        assertFalse(game.inProgress());
    }

    @Test
    public void testSurvivalGameProgress() {
        game.gameStart();
        assertTrue(game.inProgress());
    }
    
}
