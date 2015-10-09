import static org.junit.Assert.*;
import game.NormalLevelFactory;
import game.SurvivalLevelFactory;

import org.junit.Test;


public class InitCreatorsTest {

	@Test
	public void test() {
		SurvivalLevelFactory creator1 = new SurvivalLevelFactory();
		NormalLevelFactory creator2 = new NormalLevelFactory();
	}

}
