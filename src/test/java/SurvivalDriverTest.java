import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.Driver;
import game.StateManager;
import game.SurvivalDriver;
import game.states.NewGameState;
import game.states.State;
import game.states.SurvivalGameState;

import org.junit.Before;
import org.junit.Test;


public class SurvivalDriverTest {
	
	SurvivalDriver driver;
	
	@Before
	public void init() {
		driver = new SurvivalDriver();
		StateManager stateMan = new StateManager();
        stateMan.newState(new NewGameState());
        State initState = new SurvivalGameState();
        initState.handle(stateMan);
        driver.registerListeningState(initState);
        driver.driverHeart();
	}
	
	@Test
	public void testCheckGameWon() {
		
	}
	
	@Test
	public void testCheckGameLost() {
		assertFalse(SurvivalDriver.checkGameLost());
		assertTrue(Driver.game.inProgress());
		Driver.game.setLives(0);
		assertTrue(SurvivalDriver.checkGameLost());
	}

}
