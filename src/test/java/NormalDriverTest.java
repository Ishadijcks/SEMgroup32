import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.Driver;
import game.NormalDriver;
import game.StateManager;
import game.states.NewGameState;
import game.states.NormalGameState;
import game.states.State;

import org.junit.Before;
import org.junit.Test;


public class NormalDriverTest {
	
	NormalDriver driver;
	
	@Before
	public void init() {
		driver = new NormalDriver();
		StateManager stateMan = new StateManager();
        stateMan.newState(new NewGameState());
        State initState = new NormalGameState();
        initState.handle(stateMan);
        driver.registerListeningState(initState);
        driver.driverHeart();
	}

	@Test
	public void testCheckGameWon() {
		assertFalse(driver.checkGameWon());
		Driver.game.setCurrentLevelInt(driver.game.getLevelList().size());
		assertTrue(driver.checkGameWon());
	}
	
	@Test
	public void testCheckGameLost() {
		assertFalse(driver.checkGameLost());
		assertTrue(Driver.game.inProgress());
		Driver.game.setLives(0);
		assertTrue(driver.checkGameLost());
	}

}
