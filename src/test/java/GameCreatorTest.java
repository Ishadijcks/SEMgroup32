import static org.junit.Assert.assertTrue;
import game.GameFactory;
import game.NormalGame;
import game.NormalLevelFactory;
import game.Player;

import org.junit.Test;

public class GameCreatorTest {

    @Test
    public void testCreateMultiPlayer() {
        Player player1 = new Player("Test", 0);
        Player player2 = new Player("Swek", 0);
        NormalGame game = new NormalGame();
        game.addPlayer(player1);
        game.addPlayer(player2);

        game.setLevelList(new NormalLevelFactory(game.getPlayerList())
                .getAllLevels());

        assertTrue(GameFactory.createMultiPlayer(player1, player2).equals(game));
    }

}
