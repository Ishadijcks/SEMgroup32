package test.powerups;

import static org.junit.Assert.assertTrue;
import game.Game;
import game.GameFactory;
import game.NormalGame;
import game.Player;
import game.powerups.IcePowerup;

import org.junit.Before;
import org.junit.Test;

public class IcePowerupTest {
	
	IcePowerup pow;
	
	@Before
	public void init() {
		pow = new IcePowerup(0,0);
	}

	@Test
	public void testSetGame() {
		Game g = new NormalGame();
		pow.setGame(g);
	}
	
	@Test
	public void testExecuteEffect() {
		Player p = new Player("", 0);
		pow.setGame(GameFactory.createSinglePlayer(p));
		pow.executeEffect();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(p.hasIceRope());
	}

}
