

import static org.junit.Assert.*;

import java.util.ArrayList;

import game.Level;
import game.NormalLevel;
import game.NormalLevelCreator;
import game.Player;
import game.bubble.Bubble;
import game.bubble.Bubblex32;

import org.junit.Test;

public class NormalLevelCreatorTest {

	private static ArrayList<Player> playerList;

	@Test
	public void testGetLevelDefault() {
		Bubble bubble1 = new Bubblex32(100, 100, false, false);
        Level level1 = new NormalLevel(playerList);
        level1.addBubble(bubble1);
		assertTrue(NormalLevelCreator.getLevel(Integer.MAX_VALUE).equals(level1));
	}
	
	@Test
	public void testGetLevelsAvailable() {
		assertTrue(NormalLevelCreator.getLevelsAvailable() == 5);
	}

}
