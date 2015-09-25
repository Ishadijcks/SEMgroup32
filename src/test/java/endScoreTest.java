

import static org.junit.Assert.*;
import game.endScore;

import org.junit.Before;
import org.junit.Test;

public class endScoreTest {
	
	private endScore score;
	
	@Before
	public void init(){
		score = new endScore("testPerson", 500);
	}

	@Test
	public void testEndScore() {
		assertTrue(score.getName().equals("testPerson"));
		assertTrue(score.getScore() == 500);
	}

	@Test
	public void testSetName() {
		assertTrue(score.getName().equals("testPerson"));
		score.setName("TestPerson");
		assertTrue(score.getName().equals("TestPerson"));
	}
	
	@Test
	public void testSetScore() {
		assertTrue(score.getScore() == 500);
		score.setScore(0);
		assertTrue(score.getScore() == 0);
	}

	@Test
	public void testToString() {
		assertEquals("testPerson:500", score.toString());
	}

}
