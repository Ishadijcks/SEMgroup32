

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
        Level level1 = NormalLevelCreator.getLevel1();
		assertTrue(NormalLevelCreator.getLevel(Integer.MAX_VALUE).equals(level1));
	}

}
