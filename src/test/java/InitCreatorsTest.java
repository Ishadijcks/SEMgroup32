import game.NormalLevelFactory;
import game.Player;
import game.SurvivalLevelFactory;

import java.util.ArrayList;

import org.junit.Test;

public class InitCreatorsTest {

    @Test
    public void test() {
        SurvivalLevelFactory creator1 = new SurvivalLevelFactory(
                new ArrayList<Player>());
        creator1.getLevel();
        NormalLevelFactory creator2 = new NormalLevelFactory(
                new ArrayList<Player>());
        creator2.getAllLevels();
    }

}
