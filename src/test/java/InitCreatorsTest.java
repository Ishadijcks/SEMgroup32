import static org.junit.Assert.*;
import game.NormalLevelCreator;
import game.SurvivalLevelCreator;

import org.junit.Test;


public class InitCreatorsTest {

	@Test
	public void test() {
		SurvivalLevelCreator creator1 = new SurvivalLevelCreator();
		NormalLevelCreator creator2 = new NormalLevelCreator();
	}

}
