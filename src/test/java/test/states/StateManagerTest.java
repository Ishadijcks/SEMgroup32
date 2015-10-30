package test.states;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import game.NormalDriverFactory;
import game.StateManager;
import game.states.NormalGameState;
import game.states.PauseGameState;
import game.states.State;

import org.junit.Before;
import org.junit.Test;

public class StateManagerTest {
	
	StateManager stateman;
	
	@Before
	public void init() {
		stateman = new StateManager();
	}

	@Test
	public void testSetState() {
		assertNull(stateman.getState());
		State st = new NormalGameState();
		stateman.setState(st);
		assertTrue(stateman.getState().equals(st));
	}
	
	@Test
	public void testPrevState() {
		(new NormalDriverFactory()).buildDriver();
		State st = new NormalGameState();
		stateman.setState(st);
		State st2 = new PauseGameState();
		assertTrue(stateman.getState().equals(st));
		stateman.setState(st2);
		assertTrue(stateman.getState().equals(st2));
		stateman.prevState();
		assertTrue(stateman.getState().equals(st));
	}

}
