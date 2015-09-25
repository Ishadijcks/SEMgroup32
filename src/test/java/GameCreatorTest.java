

import static org.junit.Assert.*;
import game.GameCreator;
import game.NormalGame;
import game.NormalLevelCreator;
import game.Player;

import org.junit.Test;

public class GameCreatorTest {

	@Test
	public void testCreateMultiPlayer() {
		Player player1 = new Player("Test", 0, true);
		Player player2 = new Player("Swek", 0, true);
		NormalGame game = new NormalGame();
        game.addPlayer(player1);
        game.addPlayer(player2);
        NormalLevelCreator.setPlayerList(game.getPlayerList());
     
        game.addLevel(NormalLevelCreator.getLevel1());
        
        GameCreator crtr = new GameCreator();
        assertTrue(crtr.createMultiPlayer(player1, player2).equals(game));
	}

}
