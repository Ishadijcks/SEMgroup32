

import static org.junit.Assert.*;
import game.SurvivalGame;

import org.junit.Test;

public class SurvivalGameTest {

	@Test
	public void testSurvivalGame() {
		SurvivalGame game = new SurvivalGame();
		assertTrue(game.getLives() == 1);
	}

}
