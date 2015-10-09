

import static org.junit.Assert.*;

import java.util.ArrayList;

import game.Level;
import game.NormalLevel;
import game.NormalLevelFactory;
import game.Player;
import game.bubble.Bubble;
import game.bubble.Bubblex32;

import org.junit.Test;

public class NormalLevelCreatorTest {

	private ArrayList<Player> playerList;
	private NormalLevelFactory nFac = new NormalLevelFactory(playerList);

	@Test
	public void testGetLevelDefault() {
        Level level1 = nFac.getLevel1();
		assertTrue(nFac.getLevel(Integer.MAX_VALUE).equals(level1));
	}
	
	@Test
	public void testGetLevelsAvailable() {
		assertTrue(nFac.getLevelsAvailable() == 10);
	}

}
